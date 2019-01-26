package com.ragazm.ledd.model

data class TimerModel(
        val relayNumber: String,
        val timerDescription: String,
        val timerOff: String,
        val timerOn: String
) {
    override fun toString(): String {
        return "TimerModel(relayNumber='$relayNumber', timerDescription='$timerDescription', timerOff='$timerOff', timerOn='$timerOn')"
    }

}