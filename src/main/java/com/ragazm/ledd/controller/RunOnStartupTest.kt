package com.ragazm.ledd.controller


import com.ragazm.ledd.util.W1Devices
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
class RunOnStartupTest: ApplicationRunner {
    private val logger = LoggerFactory.getLogger(RunOnStartupTest::class.java)


    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        logger.debug("RunOnStartup initialized")
      // Relay.initializeGPIO()
       // W1Devices.printDeviceList()


       //Starts all scheduled jobs after server restart

        StdSchedulerFactory().scheduler.start()

    }


}
