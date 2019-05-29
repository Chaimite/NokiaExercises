import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader
{
   private String filePath;

   public FileReader(String filePath)
   {
      this.filePath = filePath;
   }

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

   // Get alarm number
   public static ArrayList<String> getAlarmNumber(String filePath)
   {
      File file = new File(filePath);
      ArrayList<String> parsedValues = new ArrayList<String>();
      try
      {
         Scanner inputStream = new Scanner(file);
         inputStream.nextLine();
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

   // Get alarm status
   public static ArrayList<String> getAlarmStatus(String filePath)
   {
      File file = new File(filePath);
      ArrayList<String> parsedValues = new ArrayList<String>();
      try
      {
         Scanner inputStream = new Scanner(file);
         inputStream.nextLine();
         while (inputStream.hasNextLine())
         {
            String data = inputStream.nextLine();
            String[] values = data.split(";");
            parsedValues.add(values[3]);
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
   public static boolean isAlarmActive(String state)
   {
      boolean value = true;
      if (state.equals("cancelled"))
      {
         value = false;
      }
      return value;
   }

   public static void main(String[] args)
   {
       Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
       String filePath =  path.toString() + "\\src\\alarms.csv";
       

      System.out.println(getAlarmNumber(filePath));
      System.out.println(getAlarmStatus(filePath));
      ArrayList<String> gAS = getAlarmStatus(filePath);
      ArrayList<String> gAN = getAlarmNumber(filePath);
      
      
      System.out.println("Active alarms:");
      for(int i = 0; i< gAS.size();i++) {
         if(isAlarmActive(gAS.get(i)) == true) {
            System.out.println(gAN.get(i));
      }

      }

   }
}
