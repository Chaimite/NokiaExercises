package exercises;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.Alarm;
import util.FileOutput;

public class Exercise2 
{

   public static void main(String[] args)
   {
     // sorted array of Alarm: sorted by number int, not string
     // do a binary search to find a same alarm.
     // Implement comparable, to compare the time stamp in different alarms
     // Should the sorting be by int or by long? Would int loose
     // accuracy or overflow?
     // when found add the new state to the found alarm. do not create new Alarm
     // probably array of states you will need in Alarm class.
      
      // Defines the path for the file on any computer (except mac)
      Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
      String filePath = path.toString() + "\\src\\alarms.csv";
      
      ArrayList<Alarm> alarms = FileOutput.getAlarmsFromFile(filePath);
      StringBuffer sb = new StringBuffer();
      String states = " ";
      
      for ( Alarm alarm : alarms)
      {
         System.out.println("Alarm being printed: " + alarm.getAlarmNum());
         if(alarm.getAlarmNum().equals(alarm.getAlarmNum())) {
            
            states = sb.append("->" + alarm.getState()).toString();
         }
         System.out.println(alarm.getAlarmNum() + ";" + states);
      }
      
     
            

   }

  
}
