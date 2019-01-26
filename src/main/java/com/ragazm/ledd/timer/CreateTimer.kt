package com.ragazm.ledd.timer

import com.ragazm.ledd.model.TimerModel
import com.ragazm.ledd.util.UtilityFunctions


/**
 * Created by Andris
 * Date: 25-Jan-19
 * Time: 21:57
 */

class CreateTimer (timer: TimerModel){

    init {
        val time = UtilityFunctions.GetTimeValues(timer)

        //Set relay on timer
        Timer(time.getOnHours(), time.getOnMinutes(), RelayOn(timer).jobDetail)
        //Set relay off timer
        Timer(time.getOffHours(), time.getOffMinutes(), RelayOff(timer).jobDetail)
    }

}