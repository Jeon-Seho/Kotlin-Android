package com.androidbook.bookmarket.mypage

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.androidbook.bookmarket.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MemoActivity : AppCompatActivity() {
    private val db by lazy { DatabaseHelperMemo(this) }
    private lateinit var memoList: ListView
    private var rows: List<Map<String, String>> = emptyList()
    private var selectedMemo: Map<String, String>? = null
    private var query = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.memo)) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        memoList = findViewById(R.id.memo_list)
        memoList.setOnItemClickListener { _, _, position, _ -> selectedMemo = rows[position] }
        findViewById<Button>(R.id.btnInsert).setOnClickListener { showEditor(null) }
        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            val memo = selectedMemo
            if (memo == null) {
                showSelectionMessage()
            } else {
                showEditor(memo)
            }
        }
        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            val id = selectedMemo?.get("id")
            if (id == null) {
                showSelectionMessage()
            } else {
                AlertDialog.Builder(this)
                    .setIcon(R.drawable.icon_memo)
                    .setTitle("메모 삭제")
                    .setMessage("선택한 메모를 삭제하겠습니까?")
                    .setPositiveButton("예") { _, _ ->
                        if (!db.delete(id)) {
                            Toast.makeText(this, "메모를 삭제하지 못했습니다.", Toast.LENGTH_SHORT).show()
                        }
                        reloadMemos()
                    }
                    .setNegativeButton("아니요", null)
                    .show()
            }
        }
        reloadMemos()
    }

    private fun showSelectionMessage() {
        Toast.makeText(this, "메모를 선택하세요.", Toast.LENGTH_SHORT).show()
    }

    private fun showEditor(memo: Map<String, String>?) {
        val view = layoutInflater.inflate(R.layout.activity_memo_dialog, null)
        val title = view.findViewById<EditText>(R.id.title)
        val content = view.findViewById<EditText>(R.id.content)
        title.setText(memo?.get("title"))
        content.setText(memo?.get("content"))
        val dialog = AlertDialog.Builder(this).setView(view).show()
        val save = view.findViewById<Button>(R.id.insert)
        if (memo != null) save.text = "수정"
        save.setOnClickListener {
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            if (db.save(memo?.get("id"), date, title.text.toString(), content.text.toString())) {
                dialog.dismiss()
                reloadMemos()
            } else {
                Toast.makeText(this, "메모를 저장하지 못했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        view.findViewById<Button>(R.id.cancel).setOnClickListener { dialog.dismiss() }
    }

    private fun reloadMemos() {
        selectedMemo = null
        rows = db.readData(query)
        memoList.adapter = SimpleAdapter(
            this, rows, R.layout.activity_memo_item,
            arrayOf("date", "title", "content"),
            intArrayOf(R.id.tvDate, R.id.tvTitle, R.id.tvContent)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu?.findItem(R.id.search)
        val searchView = searchItem?.actionView as? SearchView ?: return true
        searchView.queryHint = "메모 내용 검색"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String?): Boolean {
                searchView.clearFocus()

                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                query = text.orEmpty()
                reloadMemos()

                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        db.close()
        super.onDestroy()
    }
}