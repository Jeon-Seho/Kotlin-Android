package com.androidbook.variable

import android.util.Log

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var myAge = 20
        myAge = 25
        Log.d("코틀린: 가변 변수 var ", "나의 나이는 " + myAge)

        val myName = "홍길동"
        val age: Int = 25
//        myName = "홍길순"
        Log.d("코틀린: 불변 변수 val ", "나의 이름은 " + myName)

        var numOne = 1
        var numTwo = 300000000
        var myByte: Byte = 1
        var myInt: Int = 20
        var myLong = 25L

        Log.d("코틀린: 정수 자료형", "Int: " + numOne)
        Log.d("코틀린: 정수 자료형", "Long: " + numTwo)
        Log.d("코틀린: 정수 자료형", "Byte: " + myByte)
        Log.d("코틀린: 정수 자료형", "Int: " + myInt)
        Log.d("코틀린: 정수 자료형", "Long: " + myLong)

        var myFloat = 30.2F
        var myDouble = 35.4

        Log.d("코틀린: 실수 자료형 ", "Float: " + myFloat)
        Log.d("코틀린: 실수 자료형 ", "Double: " + myDouble)

        var myBoolean : Boolean = true

        Log.d("코틀린: 부울린 자료형 ", "Boolean: " + myBoolean)

        var myChar1 : Char = 'K'
        var myChar2 : Char = 'o'
        var myChar3 : Char = 't'
        var myChar4 : Char = 'l'
        var myChar5 : Char = 'i'
        var myChar6 : Char = 'n'

        Log.d("코틀린: 문자 자료형 ", "Char: " + myChar1 + myChar2 + myChar3 + myChar4 + myChar5 + myChar6)

        var myString1 : String = "Kotlin\n"
        var myString2 : String = "Java"

        Log.d("코틀린: 문자열 자료형 ", "String: " + myString1)
        Log.d("코틀린: 문자열 자료형 ", "String: " + myString2)

        var myArray : IntArray = intArrayOf(1, 2, 3, 4, 5)

        Log.d("코틀린: 배열 자료형 ", "배열의 3번째 값: " + myArray[2])

        var myX : Int = 100
        var myY : Long = myX.toLong()

        Log.d("코틀린: 자료형 변환 ", "Int: " + myX)
        Log.d("코틀린: 자료형 변환 ", "Long: " + myY)

        var x : Int = 4
        var y : Int = 2

        Log.d("코틀린: 산술 연산자 ", "x + y = " + (x + y))
        Log.d("코틀린: 산술 연산자 ", "x - y = " + (x - y))
        Log.d("코틀린: 산술 연산자 ", "x / y = " + (x / y))
        Log.d("코틀린: 산술 연산자 ", "x * y = " + (x * y))
        Log.d("코틀린: 산술 연산자 ", "x % y = " + (x % y))

        Log.d("코틀린: 비교 연산자", "x > y = " + (x > y))
        Log.d("코틀린: 비교 연산자", "x < y = " + (x < y))
        Log.d("코틀린: 비교 연산자", "x >= y = " + (x >= y))
        Log.d("코틀린: 비교 연산자", "x <= y = " + (x <= y))
        Log.d("코틀린: 비교 연산자", "x == y = " + (x == y))
        Log.d("코틀린: 비교 연산자", "x != y = " + (x != y))

        x = 5
        y = 10

        y += x
        Log.d("코틀린: 할당 연산자 ", "y += x => y = " + y)

        y -= x
        Log.d("코틀린: 할당 연산자 ", "y -= x => y = " + y)

        y /= x
        Log.d("코틀린: 할당 연산자 ", "y /= x => y = " + y)

        y %= x
        Log.d("코틀린: 할당 연산자 ", "y %= x => y = " + y)

        x = 1

        Log.d("코틀린: 증감 연산자 ", "++x = " + (++x))
        Log.d("코틀린: 증감 연산자 ", "--x = " + (--x))

        var _x : Boolean = true
        var _y : Boolean = false

        Log.d("코틀린: 논리 연산자 ", "x && y = " + (_x && _y))
        Log.d("코틀린: 논리 연산자 ", "x || y = " + (_x || _y))
        Log.d("코틀린: 논리 연산자 ", "!y = " + (!_y))

        var num : Int = 3
        if (num > 0) {
            Log.d("코틀린: if 조건문 ", "숫자 " + num + "은 양수")
        }

        num = 10
        if (num % 2 == 0) {
            Log.d("코틀린: if-else 조건문 ", "숫자 " + num + "은 짝수")
        } else {
            Log.d("코틀린: if-else 조건문 ", "숫자 " + num + "은 홀수")
        }

        num = -10
        var result : String
        if (num > 0) {
            result = "숫자 " + num + "은 양수"
        } else if (num == 0) {
            result = "숫자 " + num + "은 0"
        } else {
            result = "숫자 " + num + "은 음수"
        }

        Log.d("코틀린: if-else if 조건문 ", result)

        if (num > 0) {
            if (num % 2 == 0) {
                result = "숫자 " + num + "은 양수이고 짝수"
            } else {
                result = "숫자 " + num + "은 양수이고 홀수"
            }
        } else {
            if (num % 2 == 0) {
                result = "숫자 " + num + "은 음수이고 짝수"
            } else {
                result = "숫자 " + num + "은 음수이고 홀수"
            }
        }

        Log.d("코틀린: 중첩 if 조건문 ", result)

        var day : Int = 2
        when (day) {
            1 -> result = "Monday"
            2 -> result = "Tuesday"
            3 -> result = "Wednesday"
            4 -> result = "Thursday"
            5 -> result = "Friday"
            6 -> result = "Saturday"
            7 -> result = "Sunday"
            else -> result = "Invalid day"
        }

        Log.d("코틀린: when 조건문 ", result)

        for (i in 1..5) {
            Log.d("코틀린: for 반복문 ", "반복 변수" + i)
        }

        for (i in 5 downTo 1) {
            Log.d("코틀린: for 반복문 ", "반복 변수: " + i)
        }

        for (i in 5 downTo 1 step 2) {
            Log.d("코틀린: for 반복문 ", "반복 변수: " + i)
        }

        var numbers = arrayOf(1, 2, 3, 4, 5)
        for (i in numbers) {
            if (i % 2 == 1) {
                Log.d("코틀린: for 반복문 ", "반복 변수: " + i)
            }
        }

        for (i in numbers.indices) {
            Log.d("코틀린: for 반복문 ", "반복 변수: " + numbers[i])
        }

        var i = 0
        while (i <= 5) {
            Log.d("코틀린: while 반복문 ", "반복 변수: " + i)
            i++
        }

        var num1 = 3
        var num2 = 5
        var _result = mul(num1, num2)
        Log.d("코틀린: 사용자 정의 함수 ", "$num1 * $num2 = $_result")

//        _result = mul(num1)
        Log.d("코틀린: 사용자 정의 함수 ", "$num1 * 5 = $_result")

        mul(num1, num2)

        _result = mul(a = 3, b = 5)
        Log.d("코틀린: 사용자 정의 함수 ", "3 * 5 = $_result")

        var myObj = Member()
        myObj.name = "홍길동"
        myObj.age = 20
        myObj.gender = 'M'
        myObj.printMemberInfo()

        var myEmb = Employee(202201, "홍길순")

        var myPerson = Person("홍길순", 20)

        val myAnimal = Animal()
        val myDog = Dog()

        Log.d("코틀린: 객체 지향 프로그래밍 ", "Animal 클래스: ${myAnimal.sound()}")
        Log.d("코틀린: 객체 지향 프로그래밍 ", "Dog 클래스: ${myDog.sound()}")

        val myDog2 = Dog2()

        Log.d("코틀린: 객체 지향 프로그래밍 ", "Dog 클래스: ${myDog2.sound()}")
        Log.d("코틀린: 객체 지향 프로그래밍 ", "Dog 클래스: ${myDog2.sleep()}")

        val myDog3 = Dog3()

        Log.d("코틀린: 객체 지향 프로그래밍 ", "Dog 클래스: ${myDog3.sound()}")

        val myDog4 = Dog4()

        myDog4.printNames()
        myDog4.callSoundMethods()

        val lists = listOf("월요일", "화요일", "수요일", "목요일", "금요일")
        val sets = setOf(1, 2, 2, 3, 3, 3, "Java", "Java", "Kotlin")
        val maps = mapOf(1 to "Java", 2 to "Kotlin", 3 to "Android")

        Log.d("코틀린: 컬렉션", "불변 리스트: $lists")
        Log.d("코틀린: 컬렉션", "첫 번째 요일: ${lists[0]}")

        Log.d("코틀린: 컬렉션", "불변 셋: $sets")
        Log.d("코틀린: 컬렉션", "셋에 'Java' 포함 여부: ${"Java" in sets}")

        Log.d("코틀린: 컬렉션", "불변 맵: $maps")
        Log.d("코틀린: 컬렉션", "맵에서 key 2에 해당하는 값: ${maps[2]}")

//        lists.add("토요일")
//        sets.add("Swift")
//        maps[1]= "C#"

        val _lists = mutableListOf("월요일", "화요일", "수요일", "목요일", "금요일")
        val _sets = mutableSetOf(6, 10)
        val _maps = mutableMapOf(1 to "Java", 2 to "Kotlin", 3 to "Android")

        Log.d("코틀린: 컬렉션", "초기 리스트: $_lists")
        Log.d("코틀린: 컬렉션", "초기 셋: $_sets")
        Log.d("코틀린: 컬렉션", "초기 맵: $_maps")

        _lists[0] = "일요일"
        _lists.add("토요일")

        _sets.add(2)
        _sets.add(5)

        _maps[1] = "C#"
        _maps[4] = "C++"

        Log.d("코틀린: 컬렉션", "변경 후 -------------------")
        Log.d("코틀린: 컬렉션", "변경된 리스트: $_lists")
        Log.d("코틀린: 컬렉션", "변경된 셋: $_sets")
        Log.d("코틀린: 컬렉션", "변경된 맵: $_maps")

//        var name : String = "John"
//        name = null

        var name : String? = "John"
//        name = null
        val length = name?.length

        val length2 = name?:length ?: 0

        val length3 = name!!.length

        name?.let {
            println("이름의 길이는 ${it.length}입니다.")
        }

        val messageLength = name?.run {
            println("이름은 $this 입니다.")
            length
        }
        println("길이: $messageLength")

        val withresult = with(StringBuilder()) {
            append("Hello, ")
            append("Kotlin!")
            toString()
        }
        println(withresult)

        val person = Person("", 0).apply {
            this.name = "John"
            this.age = 25
        }
        println(person.name)

        val number = mutableListOf(1, 2, 3).also {
            println("리스트의 크기: ${it.size}")
            it.add(4)
        }
        println(number)
    }

    fun mul(a: Int, b: Int) : Int {
        var number = a * b
        return number
    }

//    fun mul(a: Int, b: Int = 5) : Int {
//        var number = a * b
//        return number
//    }

//    fun mul(a: Int, b: Int): Unit {
//        var number = a * b
//        Log.d("코틀린: 사용자 정의 함수 ", "$a * $b = $number")
//    }
}

open class Animal {
    open fun sound(): String {
        return "동물이 소리를 낸다"
    }
}

class Dog : Animal() {
    override fun sound(): String {
        return "멍멍"
    }
}

interface Animal2 {
    fun sound() : String
    fun sleep() : String {
        return "잠을 잔다"
    }
}

class Dog2 : Animal2 {
    override fun sound() : String {
        return "멍멍"
    }
}

abstract class Animal3 {
    abstract fun sound() : String
}

class Dog3 : Animal3() {
    override fun sound() : String {
        return "멍멍"
    }
}

open class Animal4 {
    open val name : String = "동물"
    open fun sound() : String {
        return "동물 소리"
    }

    constructor() {
        Log.d("코틀린: 객체 지향 프로그래밍", "Animal4 생성자 호출")
    }
}

class Dog4 : Animal4 {
    override val name : String = "강아지"
    override fun sound() : String {
        return "멍멍"
    }

    fun printNames() {
        Log.d("코틀린: 객체 지향 프로그래밍", "this.name = ${this.name}")
        Log.d("코틀린: 객체 지향 프로그래밍", "super.name = ${super.name}")
    }

    fun callSoundMethods() {
        Log.d("코틀린: 객체 지향 프로그래밍", "this.name = ${this.sound()}")
        Log.d("코틀린: 객체 지향 프로그래밍", "super.name = ${super.sound()}")
    }

    constructor() : super() {
        Log.d("코틀린: 객체 지향 프로그래밍", "Dog 생성자 호출")
    }
}

