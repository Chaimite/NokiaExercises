package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class State implements Comparable<State>
{
   private String state;
   private Date timeStamp;
   public static final String NEW = "new";
   public static final String UPDATE = "update";
   public static final String CANCELLED = "cancelled";
   private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

   public State(String state, String timeStamp)
   {
      super();
      this.state = state;
      setTimeStamp(timeStamp);
   }
   
   public String getState()
   {
      return state;
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
   
   @Override
   public int compareTo(State o)
   {
      return this.timeStamp.compareTo(o.timeStamp);
   }
   
   
//   @Override
//   public int compareTo(State o)
//   {
//      if(this.state.equals(o.state))
//      {
//         return 0;
//      }
//      else if(this.state.equals(NEW) || (this.state.equals(UPDATE) && o.state.equals(CANCELLED)))
//      {
//         return -1;
//      }
//      else
//      {
//         return 1;
//      }
//   }
}
