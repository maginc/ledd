package com.ragazm.ledd.timer

import com.ragazm.ledd.persistance.TimerRepository
import com.ragazm.ledd.persistance.Timers
import com.ragazm.ledd.model.TimerModel



/**
 * Created by Andris
 * Date: 25-Jan-19
 * Time: 21:57
 */

class CreateTimer (timer: TimerModel, timerRepository: TimerRepository ){

    init {

        val timeMap = TimeValues(timer)
     //   val relay = findRelayById(timer.relayNumber)




        timerRepository.save(Timers(timer.relayNumber.toInt(), timer.timerOn, timer.timerOff, timer.timerDescription))

        //Set relay on timer
        Timer(timeMap.getOnHours(), timeMap.getOnMinutes(), RelayOn(timer).jobDetail)
        //Set relay off timer
        Timer(timeMap.getOffHours(), timeMap.getOffMinutes(), RelayOff(timer).jobDetail)
    }


}

class TimeValues(var timer: TimerModel){


    fun getOnHours() = timer.timerOn.substringBefore(":").toInt()
    fun getOnMinutes() = timer.timerOn.substringAfter(":").toInt()
    fun getOffHours() = timer.timerOff.substringBefore(":").toInt()
    fun getOffMinutes() = timer.timerOff.substringAfter(":").toInt()

}