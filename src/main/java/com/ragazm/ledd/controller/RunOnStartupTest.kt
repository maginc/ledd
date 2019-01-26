package com.ragazm.ledd.controller

import org.quartz.impl.StdSchedulerFactory
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:03
 */

@Component
class RunOnStartupTest : ApplicationRunner {
    private val logger = LoggerFactory.getLogger(RunOnStartupTest::class.java)
    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        logger.debug("RunOnStartup initialized")
     //  Relay.initializeGPIO()
       // W1Devices.printDeviceList()
       // TimerModel(15,42, Relay1On.jobDetail)
        //TimerModel(15, 45, Relay1Off.jobDetail)


       //Starts all scheduled jobs after server restart
        StdSchedulerFactory().scheduler.start()



    }


}
