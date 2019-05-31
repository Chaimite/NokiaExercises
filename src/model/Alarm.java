package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Alarm 
{
   private String alarmNum;
   private String type;
   private String text;
   private String state;
   private Date timeStamp;
   private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

   public Alarm(String alarmNum, String type, String text, String state,
         String timeStamp)
   {
      super();
      this.alarmNum = alarmNum;
      this.type = type;
      this.text = text;
      this.state = state;
      setTimeStamp(timeStamp);
   }

   public String getAlarmNum()
   {
      return alarmNum;
   }

   public void setAlarmNum(String alarmNum)
   {
      this.alarmNum = alarmNum;
   }

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public String getText()
   {
      return text;
   }

   public void setText(String text)
   {
      this.text = text;
   }

   public String getState()
   {
      return state;
   }

   public void setState(String state)
   {
      this.state = state;
   }
   // Method to return time stamp in "dd/MM/yyyy HH:mm" format
   public String getTimeStamp()
   {
      return df.format(timeStamp);
   }

   public void setTimeStamp(String timeStamp)
   {
      try
      {
         this.timeStamp = df.parse(timeStamp);
      }
      catch (ParseException e)
      {
         e.printStackTrace();
      }
   }
   // Method to check the state of an alarm
   public boolean isActive()
   {
      return !state.equals("cancelled");
   }
   
   public Date getTimestampAsDate()
   {
      return timeStamp;
   }
   // Method to check if a Date object occured before another one
   public boolean isBefore(Date timestamp)
   {
      return this.timeStamp.before(timestamp);
   }

   public boolean equals(Object obj)
   {
      if (((Alarm) obj).getAlarmNum().equals(this.alarmNum))
      {
         return true;
      }
      return false;
   }
}
