package exercises;

import java.util.ArrayList;
import model.Alarm;
import util.FileOutput;

public class Exercise1 implements FilePath
{

   public static void main(String[] args)
   {
      // Retrieves and stores the information from the csv file
      ArrayList<Alarm> as = FileOutput.getAlarmsFromFile(filePath);

      // Prints out the alarms that are active
      System.out.println("Active alarms:");
      for (Alarm alarm : as)
      {
         if (alarm.isActive())
         {
            System.out.println(alarm.getAlarmNum());
         }
      }
   }
}
