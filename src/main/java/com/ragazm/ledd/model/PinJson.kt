package com.ragazm.ledd.model

import com.fasterxml.jackson.annotation.JsonCreator

data class PinJson @JsonCreator constructor(val pin1 : Int)