package my.demo

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    println("demo")

    //<editor-fold desc="自定义类示例">
    /*
        实例化对象,不需要使用new关键字
        默认提供:
            1.getters,setters(参数被var关键字修饰的提供setters函数)
            2.提供equals方法
            3.提供hashcode方法
            4.提供toString方法
            5.提供copy方法
            6.提供component1方法

     */
    //初始化
    var customer = Customer("zhangsan", "1054602234@qq.com")

    //getters
    println("Object`s name is ${customer.name}")
    println("Object`s email is ${customer.email}")

    //setters
    customer.name = "nameModified Success"
    println("Object`s name modified to ${customer.name}")

    //equals方法 copy方法
    println(customer.equals(customer))
    var copy = customer.copy()
    println("无参数copy后,调用equals方法的结果是${customer.equals(copy)}," +
            "原对象的hashcode为${customer.hashCode()}," +
            "克隆对象的hashcode为${copy.hashCode()}")
    println("无参数copy后,克隆对象的name=${customer.name},email=${customer.email}")
    var copy2 = customer.copy("copyName", "copyEmail")
    println("指定参数的copy方法(copyName,copyEmail)后," +
            "调用equals的结果为${customer.equals(copy2)}" +
            "原对象的hashcode为${customer.hashCode()}" +
            "克隆对象的hashco")
    println("指定参数的copy方法(copyName,copyEmail)后,克隆对象的name=${customer.name},email=${customer.email}")

    //toString方法
    println(customer.toString())

    //component方法
    println(customer.component1())
    println(customer.component2())

    //</editor-fold>

    //<editor-fold desc="字符串模板>
    val name = "Stirng templage"
    println("name is $name")
    //</editor-fold>

    //<editor-fold desc="类型检测">
    when (customer) {
        is Customer -> println("是同一类型")
    }
    //</editor-fold>

    //<editor-fold desc="map取值演示">
    val map = mapOf<String, String>("1" to "value1", "2" to "value2")
    for ((k, v) in map) {
        println("$k->$v")
    }
    println("通过下标的方式取值" + map["1"])
    //</editor-fold>

    //<editor-fold desc="范围在for循环中的应用">
    forRanges()
    //</editor-fold>

    println("Covert this to camelcase".spaceToCamelCase())

    //<editor-fold desc="文件示例">
    fileDemo()
    //</editor-fold>

    //<editor-fold desc="判空示例">
    ifNullable()
    //</editor-fold>
}

fun String.spaceToCamelCase(){
//    string.replace(" ","").toUpperCase()
}

data class Customer(var name: String, val email: String)

/*
    for循环中,范围演示
 */
fun forRanges() {
    //范围[1,100]
    for (i in 1..100) {

    }

    //范围[1,100)
    for (i in 1 until 100) {

    }

    //范围[2,10],步长为2
    for (i in 2..10 step 2) {

    }

    //范围[10,1]
    for (x in 10 downTo 1) {

    }
}

/*
    方法参数列表,可以是默认的数值
 */
fun foo(a: Int = 4, b: String = "") {

}

/*
    单例示例
 */
object Resource{
    val name = "Name"
}

/*
    文件示例
 */
fun fileDemo(){
    val files = File("/tmp/").listFiles()
    println(files?.size)

    val files2 = File("/tmp/tmp/").listFiles()
    println(files2?.size ?: "empty")
}

fun ifNullable(){
    val values  = mapOf<String,String>("name" to "niuyongjie","email" to "1054602234@qq.com")
    val email  = values["email"] ?: throw IllegalStateException("Email is missing!")
    values?.let {
        println("目标不为空时,执行相关操作")
    }
    val age = values["age"] ?: throw IllegalStateException("Age is missing!")//抛出异常,之后的代码不会执行

}


