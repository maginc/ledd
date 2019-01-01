package com.ragazm.ledd.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LEDController {

    public static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting(){
        return "Hello Bitch!!";
    }

    @RequestMapping("/light")
    public String light(){
        if(pin==null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"My LED", PinState.LOW);
        }
        pin.toggle();
        return "Response from light!!";
    }

}
