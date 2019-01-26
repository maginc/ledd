package com.ragazm.ledd.sensors;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Andris
 * Date: 21-Jan-19
 * Time: 21:03
 */

public  class DS18B20 {
    public static String getTemperature(String sensorId){

        String result = "No data";
        String str;
        String reading;
        // The name of the file to open.
        String fileName = "/sys/bus/w1/devices/"+sensorId+"/w1_slave";

        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            File file = ResourceUtils.getFile(fileName);
            FileInputStream inputStream =
                    new FileInputStream(file);

            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            while((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.


                reading =  new String(buffer);
                str = reading.substring(reading.lastIndexOf("t=") + 2).trim();


                result =  new StringBuilder(str).insert(str.length()-3, ".").toString();

               // total += nRead;
            }

            // Always close files.
            inputStream.close();

          //  System.out.println("Read " + total + " bytes");
        }
        catch(FileNotFoundException ex) {
            result = "Unable to open file " +
                    fileName + "";

        }
        catch(IOException ex) {
            result = "Error reading file "+ fileName + "";
            // Or we could just do this:
            // ex.printStackTrace();
        }



       return result;

    }

}
