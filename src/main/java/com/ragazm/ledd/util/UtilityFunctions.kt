package com.ragazm.ledd.util

import com.pi4j.io.gpio.GpioPinDigitalOutput
import com.ragazm.ledd.controller.Relay
import com.ragazm.ledd.model.TimerModel

/**
 * Created by Andris
 * Date: 26-Jan-19
 * Time: 15:18
 */

object UtilityFunctions{

    fun getRelayById(relayId: Int): GpioPinDigitalOutput? {
        return when(relayId){
            1 -> Relay.relay1
            2 -> Relay.relay2
            3 -> Relay.relay3
            4 -> Relay.relay5
            5 -> Relay.relay5
            6 -> Relay.relay6
            7 -> Relay.relay7
            8 -> Relay.relay8
            else -> null

        }
    }

    class GetTimeValues(var timer : TimerModel) {

        fun getOnHours() = timer.timerOn.substringBefore(":").toInt()
        fun getOnMinutes() = timer.timerOn.substringAfter(":").toInt()
        fun getOffHours() = timer.timerOff.substringBefore(":").toInt()
        fun getOffMinutes() = timer.timerOff.substringAfter(":").toInt()
    }
}