package test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestMain
{

   public static void main(String[] args)
   {
     
      testchars();
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
         System.out.println(d.toString());
         System.out.println(d2.toString());
         System.out.println(d.after(d2));
      }
      catch (ParseException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
   }
}
