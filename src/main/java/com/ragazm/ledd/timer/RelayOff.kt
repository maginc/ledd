package com.ragazm.ledd.timer

import com.ragazm.ledd.model.TimerModel
import com.ragazm.ledd.timer.RelayJobs.getRelayOffJobById
import org.quartz.Job
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.JobExecutionContext

/**
 * Created by Andris
 * fun givenPerson_whenSaved_thenFound() {
doInHibernate(({ this.sessionFactory() }), { session ->
val personToSave = Person(0, "John")
session.persist(personToSave)
val personFound = session.find(Person::class.java, personToSave.id)
session.refresh(personFound)

assertTrue(personToSave == personFound)
})
}
 * Date: 27-Jan-19
 * Time: 17:14
 */

class RelayOff(timer : TimerModel) : Job {

    private var relayId: Int = timer.relayNumber.toInt()
    private var relaySate: String = "OFF"
    private var jobDescription: String = timer.timerDescription

    var jobDetail: JobDetail = JobBuilder.newJob(getRelayOffJobById(relayId))
            .withIdentity("relay_${this.relayId}_$relaySate")
            .withIdentity("relay_${this.relayId}_$relaySate","relay_switch")
            .withDescription(jobDescription)
            .requestRecovery(true)
            .build()

    override fun execute(jobExecutionContext: JobExecutionContext) {


    }
}