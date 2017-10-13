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

fun maxOf(a: Int, b: Int): Int {
   if(a > b)
       return a
    else
       return b
}

fun maxOfWithExpression(a: Int, b: Int) = if(a > b) a else b
