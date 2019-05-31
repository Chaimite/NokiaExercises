package util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Alarm;

public class FileOutput
{
   // Method to retrieve the field names
   public static String[] getFieldNames(String filePath)
   {
      File file = new File(filePath);
      String[] values = null;
      try
      {
         Scanner inputStream = new Scanner(file);
         String line = inputStream.nextLine();
         values = line.split(";");
         inputStream.close();
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      return values;
   }
   // Method to retrieve the data from a csv file and create an array list with objects of type Alarm
   public static ArrayList<Alarm> getAlarmsFromFile(String filePath)
   {
      File file = new File(filePath);
      ArrayList<Alarm> alarms = new ArrayList<Alarm>();
      try
      {
         Scanner inputStream = new Scanner(file);
         inputStream.nextLine();
         while (inputStream.hasNextLine())
         {
            String data = inputStream.nextLine();
            String[] values = data.split(";");
            
            // check if the alarm already exists
            // if so create a State object with timeStamp and state.
            // add the state object into the Alarm.
            // otherwise create a new Alarm object and add it into the Array
            
            Alarm a = new Alarm(values[0], values[1], values[2], values[3], values[4]);
            alarms.add(a);
         }
         inputStream.close();
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      return alarms;
   }
}
