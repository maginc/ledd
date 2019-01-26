package com.ragazm.ledd.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:07
 */
public class W1Devices {

    public static void printDeviceList() throws FileNotFoundException {

        String fileName = "/sys/bus/w1/devices";
        File file = ResourceUtils.getFile(fileName);
        String[] directories = file.list((current, name) -> new File(current, name).isDirectory());

        System.out.println("List of sensors found @ /sys/bus/w1/devices :");

        if (directories != null) {
            for (int i=0; i<directories.length;i++){
               if(directories[i].contains("28")){
                    System.out.println(directories[i]);
                }
            }
        }
    }



}
