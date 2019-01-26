package com.ragazm.ledd.timer

import com.pi4j.io.gpio.GpioPinDigitalOutput
import com.ragazm.ledd.controller.Relay
import com.ragazm.ledd.model.Relay1On
import com.ragazm.ledd.model.TimerModel
import com.ragazm.ledd.util.UtilityFunctions
import org.quartz.Job
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.JobExecutionContext


/**
 * Created by Andris
 * Date: 26-Jan-19
 * Time: 14:06
 */

class RelayOn(timer: TimerModel) : Job {

    private var relayId: Int = timer.relayNumber.toInt()
    private var relaySate: String = "ON"
    private var jobDescription: String = timer.timerDescription



    var jobDetail: JobDetail = JobBuilder.newJob(Relay1On::class.java)
            .withIdentity("relay_${this.relayId}_${this.relaySate}")
            .withIdentity("relay_${this.relayId}_${this.relaySate}","relay_switch")
            .withDescription(this.jobDescription)
            .requestRecovery(true)
            .build()

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay $relayId $relaySate")
        println("Relay $relaySate")

        var relay = UtilityFunctions.getRelayById(relayId)
        relay!!.low()


    }


}