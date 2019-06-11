package exercises;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Alarm;
import util.FileOutput;

         /**
          * @author Adriano
          * 
          * I am assuming that for the equipment error type, the user will introduce a value in the 
          * range of -50000 to 50000.
          * 
          * For letter input, only upper and lower letters can be used.
          * 
          * Empty variables ha
          */
public class Exercise3 implements FilePath
{

   public static void main(String[] args)
   {
      boolean flag = true;

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
                     alarm.getAlarmNum() + "->" + alarm.getLatestState().getTimeStamp());
            }
            else if (alarm.getType().equals("equipment"))
            {
               flag = true;
               while (flag)
               {
                  System.out.println("Please insert a number between -50000 and 50000: ");
                  try
                  {
                     number = input.nextInt();
                     if (!(number >= -50000 && number <= 50000))
                     {
                        throw new InputMismatchException();
                     }

                     flag = false;
                  }
                  catch (InputMismatchException e)
                  {
                     System.err.println("Invalid Number");
                  }
                  input.nextLine();
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
