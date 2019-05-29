import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader
{
 

   // Get field names contained in .csv file
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
   
   // Return alarmNumber values   
   public static ArrayList<String> getAlarmNumber(String filePath)
   {
      File file = new File(filePath);
      FileReader fr = null;
      ArrayList<String> parsedValues = new ArrayList<String>();
      try
      {
         Scanner inputStream = new Scanner(file);
         inputStream.next();      
         while (inputStream.hasNextLine())
         {            
            String data = inputStream.nextLine();
            String[] values = data.split(";");
            parsedValues.add(values[0].toString());
         }
         inputStream.close();
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      return parsedValues;
   }
   
   
   // Check if state is cancelled
   public boolean isStateNotCanceled(String state)
   {
      boolean value = true;
      if (!state.equals("cancelled"))
      {
         value = true;
      }
      return value;
   }
   
   public static void main(String[]args) {
//      String filePath = System.getProperty("user.dir") + "\\alarms.csv";
      String filePath = "C:\\Users\\Adriano\\eclipse-workspace\\Nokia_Exercise\\src\\alarms.csv";
//      System.out.println(getFieldNames(filePath)[0]);
      System.out.println(getAlarmNumber(filePath));

   }
}
