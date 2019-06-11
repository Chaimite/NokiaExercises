package test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import model.Alarm;
import model.State;
import util.FileOutput;


public class TestMain
{

   public static void main(String[] args)
   {
     
//      testchars();
//      testdates();
//      testsearch();
//      printer();
//      testAlarmWithPQStates();
      converterTest();
   }
   
   public static void testAlarmWithPQStates()
   {
      Alarm a = new Alarm("1234", "equipment","just a message","new","01/01/2019 10:20");
      a.addState(State.CANCELLED, "01/01/2019 10:50");
      a.addState(State.UPDATE, "01/01/2019 10:22");
      
      System.out.println(a.getLatestState().getTimeStamp());

   }
   
   
   public static void testchars()
   {
      char a = 'a';
      if(a == 97)
      {
         System.out.println(a);
      }
      else
      {
         System.out.println(false);
      }
   }
   
   public static void testdates()
   {
      String testDate = "01/01/2019 10:20";
      String testDate2 = "01/01/2020 10:20";
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      try
      {
         Date d = df.parse(testDate);
         Date d2 = df.parse(testDate2);
         long miliSeconds = d.getTime();
         System.out.println(d.toString());
         System.out.println(d2.toString());
         System.out.println(d.after(d2));
         System.out.println("time in mili seconds: " + miliSeconds);
      }
      catch (ParseException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
   }
   public static void testsearch() {
      ArrayList<Integer> data = new ArrayList<Integer>();
      data.add(50);
      data.add(9);
      data.add(900);
      data.add(250);
      data.add(2);
      Collections.sort(data);
      int finder = Collections.binarySearch(data, 9);
      System.out.println("Location is at: " + finder);
      
   }
   public static void printer() {
     Scanner input = new Scanner (System.in);
      int number;
      boolean flag = true;
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
   public static void converterTest() {
      int number = 12345;
      String asAString = Integer.toString(number);
//      System.out.println("This the number converted into a string: " + asAString);
      Stack<Character> trying = new Stack<Character>();
     for(int i = 0; i < asAString.length(); i++) {
        trying.push(asAString.charAt(i));
       
        
     }
     System.out.println(trying);
     System.out.println(trying.peek());
     trying.pop();
     System.out.println(trying.peek());
   }
}
