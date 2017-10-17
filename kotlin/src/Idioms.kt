package my.demo

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
    var copy  = customer.copy()
    println("无参数copy后,调用equals方法的结果是${customer.equals(copy)}," +
            "原对象的hashcode为${customer.hashCode()}," +
            "克隆对象的hashcode为${copy.hashCode()}")
    println("无参数copy后,克隆对象的name=${customer.name},email=${customer.email}")
    var copy2 = customer.copy("copyName","copyEmail")
    println("指定参数的copy方法(copyName,copyEmail)后," +
            "调用equals的结果为${customer.equals(copy2)}" +
            "原对象的hashcode为${customer.hashCode()}" +
            "克隆对象的hashco")
    println("指定参数的copy方法(copyName,copyEmail)后,克隆对象的name=${customer.name},email=${customer.email}")

    //</editor-fold>

}

data class Customer(var name: String, val email: String)




