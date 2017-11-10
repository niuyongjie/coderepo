package my.demo

/*
    Kotlin  包含三种形式的跳转语句
    return  跳出离它最近的方法体
    break   结束本次循环
    continue结束本次循环,跳转到下次循环中
    其中break和continue支持标记跳转
 */
fun main(args: Array<String>) {
    returnExpression()
}

fun returnExpression() {
    /*
        return,break,continue可以用作任意表达式中的一部分
     */

    var person = "person"
    val s = person ?: return
    /*
        相当于Java中的
        if(StringUtils.isNotEmpty(person)){
            val s = person
        }else {
            return
        }
     */

    //跳转标记示例
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 10) break@loop
        }
    }

    //return 可以跳出当前方法体到外层方法体中,常用于lambda表达式
    fun foo() {
        val ints = arrayOf(1, 2, 3, 4)
        ints.forEach lit@ {
            if (it == 0) return@lit
            println(it)
        }
    }

    //在lambda表达式中可以隐藏跳转标记,来简化编码,跳转标记必须和方法名相同,用"@"标记,并且和return之间没有空格
    fun foo1() {
        val ints = arrayOf(1, 2, 3, 4, 5)
        ints.forEach { if(it == 0) return@forEach println(it) }
    }

    //跳转标记还可以携带参数
    // return@forEach 1

}
