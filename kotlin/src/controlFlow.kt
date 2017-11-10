package my.demo.ifdemo

import my.demo.parseInt

/**
 * 流程控制语法示例
 *
 */
fun main(args: Array<String>) {
    ifExperssion()
    whenExperssion()
    forExpression()
}


/**
 * if语句示例
 *
 */
fun ifExperssion() {
    /*
        在Kotlin中,if语句被看成是一个表达式,
     */

    var a = 123
    var b = 11
    var max = a
    if (a < b) max = b //单条件语句

    if (a < b) { // if-else语句形式
        max = a
    } else {
        max = b
    }

    max = if (a > b) a else b //表达式形式,类似于三元运算符

}

/**
 * when语句示例
 *
 * when和if语句一样,可以用作单独的语句,也可以表达式的形式出现
 */
fun whenExperssion() {
    var x = 3
    when (x) {
        1 -> println("this is $x")
        2 -> println("two")
        else -> {
            println("$x is not is 1 or 2")
        }
    }

    //在when中,如果有个情景执行相同的代码,可以将这些条件用","分割简写
    when (x) {
        1, 2 -> println("this argument is $x")
    }

    //when的分之表达式可以是随意的表达式
    when (x) {
        parseInt("4") -> println(" x can be paresInt")
        in 1..10 -> println("x is in [1,10) range")
        !in 1..10 -> println("x is out in [1,10) range")
    }

    //when的示例:判断某个字符串是否包含前缀,参数类型为Any,程序会自动进行类型转换
    fun hasPrefix(x: Any) = when(x){
        is String -> x.startsWith("prefix")
        else -> false
    }

    //when不写参数,可以用作if-else链
//    when {
//        x.isOld() -> println("x is Old")
//        x.isYong() -> println("x is yong")
//        else -> println("not old and yong")
//    }

}

/**
 * for循环示例
 */
fun forExpression() {
/*  foreach形式一:
    for(item in collection) println("xxxx")
    foreach形式二:
    for(item: Int in collection){
      println("xxxx")
    }*/

    /*
        for循环可以循环任何包含迭代器性质的类型
        具有迭代特性必须包含:
        iterator()
        next()
        hasNext()
     */

    //通过下标的形式循环集合
    var array = arrayOf(2, 3, 5, 6, "3", 1, 'a')
    for (i in array.indices) {
        println(array[i])
    }

    //通过withIndex形式循环集合
    for ((index, value) in array.withIndex()) {
        println("$index 的值为: $value")
    }

    //Kotlin语法中也包含传统的while 和 do...while

}
