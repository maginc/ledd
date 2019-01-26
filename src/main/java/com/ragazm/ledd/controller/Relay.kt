package com.ragazm.ledd.controller

import com.pi4j.io.gpio.GpioFactory
import com.pi4j.io.gpio.GpioPinDigitalOutput
import com.pi4j.io.gpio.PinState
import com.pi4j.io.gpio.RaspiPin

/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:03
 */

class Relay {
    companion object {

        var relay1: GpioPinDigitalOutput? = null
        var relay2: GpioPinDigitalOutput? = null
        var relay3: GpioPinDigitalOutput? = null
        var relay4: GpioPinDigitalOutput? = null
        var relay5: GpioPinDigitalOutput? = null
        var relay6: GpioPinDigitalOutput? = null
        var relay7: GpioPinDigitalOutput? = null
        var relay8: GpioPinDigitalOutput? = null

        fun initializeGPIO() {
            val gpio = GpioFactory.getInstance()

            if (relay1 == null) {
                relay1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "My LED", PinState.LOW)
            }

            if (relay2 == null) {
                relay2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "My LED", PinState.LOW)

            }

            if (relay3 == null) {

                relay3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "My LED", PinState.LOW)

            }
            if (relay4 == null) {

                relay4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "My LED", PinState.LOW)

            }

            if (relay5 == null) {

                relay5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "My LED", PinState.LOW)

            }
            if (relay6 == null) {

                relay6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "My LED", PinState.LOW)

            }
            if (relay7 == null) {

                relay7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "My LED", PinState.LOW)

            }

            if (relay8 == null) {

                relay8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "My LED", PinState.LOW)

            }
            println("Relays initialized successfully")

        }
    }
}