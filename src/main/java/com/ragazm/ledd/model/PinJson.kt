package com.ragazm.ledd.model

import com.fasterxml.jackson.annotation.JsonCreator

/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:03
 */

 data class PinJson @JsonCreator constructor(val pinNumber : Int)