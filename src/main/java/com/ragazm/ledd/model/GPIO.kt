package com.ragazm.ledd.model

import org.springframework.stereotype.Component
/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:03
 */

data class GPIO(val pin4On: Int = -1, val pin17On: Int = -1, val pin27On: Int = -1,
                val pin22On: Int = -1, val pin10On: Int = -1, val pin9On: Int = -1,
                val pin5On: Int = -1, val pin6On: Int = -1, val pin13On: Int = -1,
                val pin19On: Int = -1, val pin26On: Int = -1, val pin18On: Int = -1,
                val pin23On: Int = -1, val pin24On: Int = -1, val pin25On: Int = -1,
                val pin8On: Int = -1, val pin7On: Int = -1, val pin12On: Int = -1,
                val pin16On: Int = -1, val pin20On: Int = -1, val pin21On: Int = -1)