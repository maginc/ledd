package com.ragazm.ledd

import com.pi4j.io.i2c.I2CFactory
import com.ragazm.ledd.sensors.BME280
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import java.io.IOException

@SpringBootApplication
class Application

    fun main(args: Array<String>) {
        runApplication<Application>(*args)


        while (true) {
            try {
                BME280.sensor()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: I2CFactory.UnsupportedBusNumberException) {
                e.printStackTrace()
            }

            Thread.sleep(3000)

        }

    }
