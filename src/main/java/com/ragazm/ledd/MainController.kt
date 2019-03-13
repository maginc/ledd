package com.ragazm.ledd

import com.ragazm.ledd.controller.Relay
import com.ragazm.ledd.persistance.TimerRepository
import com.ragazm.ledd.model.PinJson
import com.ragazm.ledd.model.TimerModel
import com.ragazm.ledd.sensors.BME280
import com.ragazm.ledd.sensors.DS18B20
import com.ragazm.ledd.timer.CreateTimer

import org.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:03
 */
@CrossOrigin
@RestController
class MainController(private val timerRepository: TimerRepository)
{
    private val logger = LoggerFactory.getLogger(MainController::class.java)

    @RequestMapping("/timertimetable", method = [RequestMethod.GET], produces = ["application/json"])
    fun getTimerTimeTable() = listOf(timerRepository.findAll())

    @RequestMapping("/sensors", method = [RequestMethod.GET], produces = ["application/json"])
    fun getSensorValues() = hashMapOf("temperature" to BME280.sensor()["Temperature"], "humidity" to BME280.sensor()["Humidity"])

    @CrossOrigin
    @RequestMapping("/time", method = [org.springframework.web.bind.annotation.RequestMethod.GET], produces = ["application/json"])
    fun getCurrentTime():String{
        val result = JSONObject()

        val current = LocalDateTime.now()

        val time = DateTimeFormatter.ofPattern("HH:mm:ss")
        val date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedTime = current.format(time)
        val formattedDate = current.format(date)

        result.put("time", formattedTime)
        result.put("date", formattedDate)

      //  println("Current Date and Time is: $formatted")
        return result.toString()
    }


    @RequestMapping("/w1sensors/{sensorId}", method = [RequestMethod.GET], produces = ["application/json"])
    fun getW1SensorData(@PathVariable sensorId : String ): String{
        val result = JSONObject()
        result.put("temperature", (DS18B20.getTemperature(sensorId)).toDouble())
        result.put("id", sensorId)


        return result.toString()
    }

    @RequestMapping("/checkallrelaystate", method = [RequestMethod.GET], produces = ["application/json"])
    fun checkAllRelayState () : String {

        val result = JSONObject()

        result.put("relay1", "1"+ Relay.relay1!!.state.value)
        result.put("relay2", "2"+ Relay.relay2!!.state.value)
        result.put("relay3", "3"+ Relay.relay3!!.state.value)
        result.put("relay4", "4"+ Relay.relay4!!.state.value)
        result.put("relay5", "5"+ Relay.relay5!!.state.value)
        result.put("relay6", "6"+ Relay.relay6!!.state.value)
        result.put("relay7", "7"+ Relay.relay7!!.state.value)
        result.put("relay8", "8"+ Relay.relay8!!.state.value)

        return result.toString()
    }

    @RequestMapping("/timer", method = [RequestMethod.POST], produces = ["application/json"])
    fun timer(@RequestBody timer: TimerModel): String {
        val result = JSONObject()

        CreateTimer(timer, timerRepository)

        result.put("response", "ok")

        return result.toString()
    }

    @RequestMapping("/gettimers", method = [RequestMethod.GET], produces = ["application/json"])
    fun getTimers(): String {
        val result = JSONObject()



        result.put("response", "ok")

        return result.toString()
    }

    @RequestMapping("/pincontrol", method = [RequestMethod.POST], produces = ["application/json"])
    fun light(@RequestBody pinname: PinJson): String {
        val result = JSONObject()

        when (pinname.pinNumber) {
        1 -> {
            Relay.relay1!!.toggle()
            result.put("response", "1" + Relay.relay1!!.state.value)
        }
        2 -> {
            Relay.relay2!!.toggle()
            result.put("response", "2" + Relay.relay2!!.state.value)
        }
        3 -> {
            Relay.relay3!!.toggle()
            result.put("response", "3" + Relay.relay3!!.state.value)
        }
        4 -> {
            Relay.relay4!!.toggle()
            result.put("response", "4" + Relay.relay4!!.state.value)
        }
        5 -> {
            Relay.relay5!!.toggle()
            result.put("response", "5" + Relay.relay5!!.state.value)
        }
        6 -> {
            Relay.relay6!!.toggle()
            result.put("response", "6" + Relay.relay6!!.state.value)
        }
        7 -> {
            Relay.relay7!!.toggle()
            result.put("response", "7" + Relay.relay7!!.state.value)
        }
        8 -> {
            Relay.relay8!!.toggle()
            result.put("response", "8" + Relay.relay8!!.state.value)
        }
        else -> {
        result.put("response","00")
        }
        }

        return result.toString()
    }

}
