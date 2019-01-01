package com.ragazm.ledd


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class Application
    //@JvmStatic

    fun main(args: Array<String>) {
        runApplication<Application>(*args)


}