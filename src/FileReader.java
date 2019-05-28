import java.io.File;
import java.io.FileNotFoundException;
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
      ArrayList<String> parsedValues = new ArrayList<String>();
      try
      {
         Scanner inputStream = new Scanner(file);
         inputStream.next();
//         inputStream.useDelimiter(";");
         while (inputStream.hasNext())
         {
            
            String data = inputStream.next();
//            System.out.println(data + "***");
//            String[] values = data.split(";");
            parsedValues.add(data);
         }
         inputStream.close();
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      return parsedValues;
   }
   public static void main(String[]args) {
//      String filePath = System.getProperty("user.dir") + "\\alarms.csv";
      String filePath = "C:\\Users\\Adriano\\eclipse-workspace\\Nokia_Exercise\\src\\alarms.csv";
//      System.out.println(getFieldNames(filePath)[0]);
      System.out.println(getAlarmNumber(filePath).get(0));
   }
}
