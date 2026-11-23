package com.androidbook.bookmarket.mypage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelperMemo(context: Context) : SQLiteOpenHelper(context, "Memo.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE MemoTABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, title TEXT, content TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) = Unit

    fun readData(query: String): List<Map<String, String>> {
        val columns = arrayOf("id", "date", "title", "content")
        val selection = if (query.isEmpty()) null else "content LIKE ?"
        val args = if (selection == null) null else arrayOf("%$query%")

        return readableDatabase.query("MemoTABLE", columns, selection, args, null, null, "id DESC").use { cursor ->
            buildList {
                while (cursor.moveToNext()) {
                    add(columns.mapIndexed { index, column -> column to cursor.getString(index).orEmpty() }.toMap())
                }
            }
        }
    }

    fun save(id: String?, date: String, title: String, content: String): Boolean {
        val values = ContentValues().apply {
            put("date", date)
            put("title", title)
            put("content", content)
        }

        return if (id == null) {
            writableDatabase.insert("MemoTABLE", null, values) != -1L
        } else {
            writableDatabase.update("MemoTABLE", values, "id = ?", arrayOf(id)) == 1
        }
    }

    fun delete(id: String): Boolean =
        writableDatabase.delete("MemoTABLE", "id = ?", arrayOf(id)) == 1
}