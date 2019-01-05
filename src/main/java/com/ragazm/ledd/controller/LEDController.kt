package com.ragazm.ledd.controller

import com.pi4j.io.gpio.*
import com.ragazm.ledd.sensors.BME280
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LEDController {

   // @RequestMapping("/")
    //fun greeting() = "index"


    @RequestMapping("/temperature")
    fun temperature(): String {
        var doubleTemp = BME280.sensor()["Temperature"]
        var doubleHumidity = BME280.sensor()["Humidity"]

        return doubleTemp.toString() + "<br>" + doubleHumidity.toString()
    }

    @RequestMapping("/light")
    fun light(): String {
        if (pin == null) {
            val gpio = GpioFactory.getInstance()
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "My LED", PinState.LOW)
        }
        pin!!.toggle()
        return "Response from light!!"
    }

    companion object {

        var pin: GpioPinDigitalOutput? = null
    }

}
