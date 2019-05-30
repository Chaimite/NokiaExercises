package exercises;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Alarm;
import util.FileOutput;

public class Exercise3
{

   public static void main(String[] args)
   {
      boolean flag = true;
      // Defines the path for the file on any computer (except mac)
      Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
      String filePath = path.toString() + "\\src\\alarms.csv";

      // Data input from csv file
      ArrayList<Alarm> alarms = FileOutput.getAlarmsFromFile(filePath);

      Scanner input = new Scanner(System.in);
      int number;
      char letter;
      System.out.println("Actions taken in different situations");

      for (Alarm alarm : alarms)
      {
         System.out.println(alarm.getAlarmNum());
         if (alarm.isActive())
         {
            if (alarm.getType().equals("processingError"))
            {
               System.out.println(
                     alarm.getAlarmNum() + "->" + alarm.getTimeStamp());
            }
            else if (alarm.getType().equals("equipment"))
            {
               flag = true;
               while (flag)
               {
                  System.out.println(
                        "Please insert a number between -5000 and 5000: ");
                  try
                  {
                     number = input.nextInt();
                     if (!(number >= -5000 && number <= 5000))
                     {
                        throw new InputMismatchException();
                     }

                     flag = false;
                     input.nextLine();
                  }
                  catch (InputMismatchException e)
                  {
                     System.err.println("Invalid Number");
                  }
               }
            }
            else if (alarm.getType().equals("physicalViolation"))
            {
               flag = true;
               while (flag)
               {
                  System.out.println("Please insert a letter: ");
                  try
                  {
                     letter = input.next().charAt(0);
                     if (!((letter >= 65 && letter <= 90)
                           || (letter >= 97 && letter <= 122)))
                     {
                        throw new InputMismatchException();
                     }

                     flag = false;
                  }
                  catch (InputMismatchException e)
                  {
                     System.err.println("Invalid Number");
                  }
               }
            }
            else
            {
               System.out.println("Unidentified error");
            }
         }
      }
      input.close();
   }

}
