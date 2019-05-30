package exercises;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import model.Alarm;
import util.FileOutput;

public class Exercise1
{

   public static void main(String[] args)
   {
      // Defines the path for the file on any computer (except mac)
      Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
      String filePath = path.toString() + "\\src\\alarms.csv";

      // Retrieves and stores the information from the csv file
      ArrayList<Alarm> as = FileOutput.getAlarmsFromFile(filePath);

      // Prints out the alarms that are active
      System.out.println("Active alarms:");
      for (Alarm alarm : as)
      {
         if(alarm.isActive())
         {
            System.out.println(alarm.getAlarmNum());
         }
      }
   }
}
