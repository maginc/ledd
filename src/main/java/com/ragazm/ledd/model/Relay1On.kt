package com.ragazm.ledd.model

import com.ragazm.ledd.controller.Relay
import org.quartz.Job
import org.quartz.JobExecutionContext

/**
 * Created by Andris
 * Date: 26-Jan-19
 * Time: 18:05
 */

class Relay1On() : Job {


    override fun execute(jobExecutionContext: JobExecutionContext) {
        Relay.relay1!!.low()
    }

}