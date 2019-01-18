package com.ragazm.ledd.controller

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.pi4j.io.gpio.*
import com.ragazm.ledd.sensors.BME280
import com.ragazm.ledd.model.GPIO
import com.ragazm.ledd.model.PinJson
import org.json.JSONObject
import org.springframework.web.bind.annotation.*


@RestController
class LEDController {


    /**
    @RequestMapping("/temperature")
    fun temperature(): String {
    var doubleTemp = BME280.sensor()["Temperature"]
    var doubleHumidity = BME280.sensor()["Humidity"]

    return doubleTemp.toString() + "<br>" + doubleHumidity.toString()
    }

     **/
    @ResponseBody
    @RequestMapping("/sensors", method = [RequestMethod.GET], produces = ["application/json"])
    fun getSensorValues(): HashMap<String, Any?> {


    return hashMapOf("temperature" to BME280.sensor()["Temperature"],"humidity" to BME280.sensor()["Humidity"])
}


    @RequestMapping("/pincontrol", method = [RequestMethod.POST], produces = ["application/json"])
    fun light(@RequestBody pinname : PinJson): String {

        System.out.println("received string: $pinname")
        System.out.println("pin1: ${pinname.pin1}")
        val result = JSONObject()


        val gpio = PinJson(pinname.pin1)
        if (pinname.pin1 == 1) {
            val gpio = GpioFactory.getInstance()
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "My LED", PinState.LOW)
            pin!!.toggle()

            System.out.println("PIN TOGGLED")
            result.put("pin1", "switched")
        }else{
            result.put("ERROR", "something went wrong")
        }


        return result.toString()
    }

    companion object {

        var pin: GpioPinDigitalOutput? = null
    }



}
