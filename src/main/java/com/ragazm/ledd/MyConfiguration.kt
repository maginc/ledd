package com.ragazm.ledd

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Andris
 * Date: 24-Jan-19
 * Time: 13:00
 */
@Configuration
class MyConfiguration {
    private val logger = LoggerFactory.getLogger(MyConfiguration::class.java)
    @Bean
    fun beanTest() {


        logger.debug("Bean test")
    }
}
