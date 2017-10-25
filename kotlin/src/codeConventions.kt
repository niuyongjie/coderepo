package my.demo

fun main(args: Array<String>) {
    /*
        命名规则
        1. 采用驼峰命名法(不包括下划线)
        2. 类型第一个字母大写
        3. 方法和属性名第一个字母小写
        4. 使用4个空格缩进
        5. public修饰的方法应当包含文档
     */


    lambdaExperssion()
}

/*
    colon冒号分隔规则:
    类型 : 类型  -> 前后都有空格分隔
    实例: 类型   -> 后边用一个都好分隔

interface Foo<out T : Any> : Object{
    fun foo(a: Int): T
}
*/

/*
    lambda表达式
 */
fun lambdaExperssion() {
    var list = listOf<Int>(3, 4, 5, 10, 12, 20, 40)
    list.filter { it > 10 }.map { element -> element * 2 }
}

/*
    类体的定义方式
    1.单行形式
    class Person(id: Int, name: String)
    2.多行形式,构造器中:每个参数单独占一行,右括号单独占一行,
                     继承或者实现的接口跟在右括号的后面,注意参数对齐
    class Person(
        id: Int,
        name: String,
        age: Int
    ) : Human(id, name),        //集成类
        KotlinMaker{            //实现接口
        //...
    }
 */


