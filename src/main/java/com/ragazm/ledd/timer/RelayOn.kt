package com.ragazm.ledd.timer

import com.ragazm.ledd.model.TimerModel
import com.ragazm.ledd.timer.RelayJobs.getRelayOnJobById
import org.quartz.Job
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.JobExecutionContext

/**
 * Created by Andris
 * Date: 26-Jan-19
 * Time: 14:06
 */

class RelayOn(timer : TimerModel) : Job {

    private var relayId: Int = timer.relayNumber.toInt()
    private var relaySate: String = "ON"
    private var jobDescription: String = timer.timerDescription

    var jobDetail: JobDetail = JobBuilder.newJob(getRelayOnJobById(relayId))
            .withIdentity("relay_${this.relayId}_$relaySate")
            .withIdentity("relay_${this.relayId}_$relaySate","relay_switch")
            .withDescription(jobDescription)
            .requestRecovery(true)
            .build()

    override fun execute(jobExecutionContext: JobExecutionContext) {


    }
}