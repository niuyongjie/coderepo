package my.demo

import org.omg.CORBA.Object

fun main(args: Array<String>) {
    /*
        命名规则
        1. 采用驼峰命名法(不包括下划线)
        2. 类型第一个字母大写
        3. 方法和属性名第一个字母小写
        4. 使用4个空格缩进
        5. public修饰的方法应当包含文档
     */
    }

/*
    colon冒号分隔规则:
    类型 : 类型  -> 前后都有空格分隔
    实例: 类型   -> 后边用一个都好分隔
 */
interface Foo<out T : Any> : Object{
    fun foo(a: Int): T
}