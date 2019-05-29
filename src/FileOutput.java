import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOutput
{
   private String filePath;

   public FileOutput(String filePath)
   {
      this.filePath = filePath;
   }

   // Get field names contained in .csv file
   public String[] getFieldNames(String filePath)
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
   public ArrayList<String> getAlarmNumber(String filePath)
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
   public ArrayList<String> getAlarmStatus(String filePath)
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
   public boolean isAlarmActive(String state)
   {
      boolean value = true;
      if (state.equals("cancelled"))
      {
         value = false;
      }
      return value;
   }
}
