package my.demo

import java.util.*
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    //<editor-fold desc="函数定义-完整形式">
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    //</editor-fold>

    //<editor-fold desc="函数定义-表达式形式">
    println("sum of 9 and 23 is ${sumWithExpression(9, 23)}")
    //</editor-fold>

    //<editor-fold desc="函数返回类型为弱类型,没有明确指定返回的数据是什么类型">
    printSum(-1, 8)
    //</editor-fold>

    //<editor-fold desc="定义本地常量">
    val a: Int = 1 //声明局部常量,并立即赋值
    val b = 2 //程序根据值,推断为Int类型
    val c: Int //声明局部常量但不立即初始化时,必须指定变量的类型
    c = 3
    println("a = $a, b = $b, c = $c ")
    //</editor-fold>

    //<editor-fold desc="定义局部变量">
    var x = 5
    x += 1
    println("x = $x")
    //</editor-fold>

    //<editor-fold desc="字符串模板">
    stringTemplate()
    //</editor-fold>

    //<editor-fold desc="条件表达式">
    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("max of With Expression 0 and 42 is ${maxOfWithExpression(0, 42)}")
    //</editor-fold>

    //<editor-fold desc="null判断和返回">
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")
    //</editor-fold>

    //<editor-fold desc="is 操作符判断是否属于某个类型">
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"}")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
    //</editor-fold>

    //<editor-fold desc="循环示例">
    val items = listOf<String>("apple", "banna", "kiwi")
    for (item in items) {
        println(item)
    }
    //</editor-fold>

    //<editor-fold desc="循环示例2">
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    //</editor-fold>

    //<editor-fold desc="循环示例2">
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
    //</editor-fold>

    //<editor-fold desc="分支语句示例">
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
    //</editor-fold>

    //<editor-fold desc="通过in操作符判断范围">
    val x1 = 10
    val y = 9
    if (x1 in 1 .. y + 1) {
        println("fits in range")
    }
    //</editor-fold>

    //<editor-fold desc="通过in操作符判断范围">
    val list = listOf<String>("a", "b", "c")
    if (-1 in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println(list.size)
        println(list.indices)
        println("list size is out of valid list indices range too")
    }
    //</editor-fold>

    //<editor-fold desc="循环迭代范围">
    for( x in 0..5){
        println(x)
    }
    //</editor-fold>
}


/**
 * 函数定义--完整形式,名称为sum,有两个Int类型的参数,返回值也是Int类型
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * 函数定义--表达式形式,隐藏了返回类型
 */
fun sumWithExpression(a: Int, b: Int) = a + b

/**
 * 函数返回类型为弱类型,没有明确指定返回的数据是什么类型
 */
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

/*
    字符串模板
 */
fun stringTemplate() {
    var a = 1;
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s1)
    println(s2)
}

/*
    条件语句
 */
fun maxOf(a: Int, b: Int): Int {
    if (a > b)
        return a
    else
        return b
}

/*
    条件语句--表达式形式
 */
fun maxOfWithExpression(a: Int, b: Int) = if (a > b) a else b

/*
    返回类型可能会空的情况
 */
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

/*
    如何判断null
 */
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y !== null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

/*
    is 操作符来判断是否属于某个类型
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) return obj.length
    return null
}

/*
    when条件分之语句示例
 */
fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Is Not String"
            else -> "Unknown"
        }

