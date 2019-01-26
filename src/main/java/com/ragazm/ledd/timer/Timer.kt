package com.ragazm.ledd.timer

import org.quartz.*
import org.quartz.impl.StdSchedulerFactory

/**
 * Created by Andris
 * Date: 24-Jan-19
 * Time: 13:49
 */
class Timer @Throws(SchedulerException::class)
constructor(private val hours: Int, private val minutes: Int, private val job: JobDetail) {

    init {

        println(job.description + " created")

        val factory = StdSchedulerFactory()
        val scheduler = factory.scheduler
        scheduler.start()

        val trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.dailyAtHourAndMinute(hours, minutes))
                .build()
        scheduler.deleteJob(job.key)
       // scheduler.rescheduleJob(,job.key)
        scheduler.scheduleJob(job, trigger)
    }
}
