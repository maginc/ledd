package com.ragazm.ledd.timer

import com.ragazm.ledd.controller.Relay
import org.quartz.Job
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.JobExecutionContext

/**
 * Created by Andris
 * Date: 26-Jan-19
 * Time: 18:42
 */
object RelayJobs{

    fun getRelayOnJobById(relayId: Int) : Class<out Job>? {

        return when(relayId){
            1 -> Relay1On::class.java
            2 -> Relay2On::class.java
            3 -> Relay3On::class.java
            4 -> Relay4On::class.java
            5 -> Relay5On::class.java
            6 -> Relay6On::class.java
            7 -> Relay7On::class.java
            8 -> Relay8On::class.java
            else -> null
        }
    }

    fun getRelayOffJobById(relayId: Int) : Class<out Job>? {

        return when(relayId){
            1 -> Relay1Off::class.java
            2 -> Relay2Off::class.java
            3 -> Relay3Off::class.java
            4 -> Relay4Off::class.java
            5 -> Relay5Off::class.java
            6 -> Relay6Off::class.java
            7 -> Relay7Off::class.java
            8 -> Relay8Off::class.java
            else -> null
        }
    }
}

class Relay1On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 1 on")
        Relay.relay1!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay1On::class.java)
                .withIdentity("relay_1_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay1Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 1 off")
        Relay.relay1!!.high()


    }

    companion object {

        var jobDetail: JobDetail = JobBuilder.newJob(Relay1Off::class.java)
                .withIdentity("relay_1_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}

class Relay2On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 2 on")
        Relay.relay2!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay2On::class.java)
                .withIdentity("relay_2_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay2Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 2 off")
        Relay.relay2!!.high()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay1Off::class.java)
                .withIdentity("relay_2_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}

class Relay3On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 3 on")
        Relay.relay3!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay3On::class.java)
                .withIdentity("relay_3_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay3Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 3 off")
        Relay.relay3!!.high()

    }

    companion object {

        var jobDetail: JobDetail = JobBuilder.newJob(Relay3Off::class.java)
                .withIdentity("relay_3_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}

class Relay4On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 4 on")
        Relay.relay4!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay4On::class.java)
                .withIdentity("relay_4_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay4Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 4 off")
        Relay.relay4!!.high()

    }

    companion object {

        var jobDetail: JobDetail = JobBuilder.newJob(Relay4Off::class.java)
                .withIdentity("relay_4_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}

class Relay5On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 5 on")
        Relay.relay5!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay5On::class.java)
                .withIdentity("relay_5_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay5Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 5 off")
        Relay.relay5!!.high()

    }

    companion object {

        var jobDetail: JobDetail = JobBuilder.newJob(Relay5Off::class.java)
                .withIdentity("relay_5_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}

class Relay6On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 6 on")
        Relay.relay6!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay6On::class.java)
                .withIdentity("relay_6_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay6Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 6 off")
        Relay.relay6!!.high()

    }

    companion object {

        var jobDetail: JobDetail = JobBuilder.newJob(Relay6Off::class.java)
                .withIdentity("relay_6_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}

class Relay7On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 7 on")
        Relay.relay7!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay7On::class.java)
                .withIdentity("relay_7_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay7Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 7 off")
        Relay.relay7!!.high()

    }

    companion object {

        var jobDetail: JobDetail = JobBuilder.newJob(Relay7Off::class.java)
                .withIdentity("relay_7_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}

class Relay8On : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 8 on")
        Relay.relay8!!.low()

    }

    companion object {

        var jobDetail = JobBuilder.newJob(Relay8On::class.java)
                .withIdentity("relay_8_on","relay_switch")
                .requestRecovery(true)
                .build()!!
    }

}

class Relay8Off : Job {

    override fun execute(jobExecutionContext: JobExecutionContext) {

        println("Relay 8 off")
        Relay.relay8!!.high()

    }

    companion object {

        var jobDetail: JobDetail = JobBuilder.newJob(Relay8Off::class.java)
                .withIdentity("relay_8_off","relay_switch")
                .requestRecovery(true)
                .build()
    }

}