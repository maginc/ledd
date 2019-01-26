package com.ragazm.ledd


import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:03
 */

@SpringBootApplication
class Application

private val logger = LoggerFactory.getLogger(Application::class.java)
    fun main(args: Array<String>) {
        runApplication<Application>(*args)
        logger.debug("STARTED!!")

    }

