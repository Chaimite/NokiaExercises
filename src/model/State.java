package model;

import java.util.Date;

public class State implements Comparable<State>
{
   private String state;
   private Date timeStamp;
   public static final String NEW = "new";
   public static final String UPDATE = "update";
   public static final String CANCELLED = "cancelled";

   public State(String state)
   {
      super();
      this.state = state;
   }
   
   public String getState()
   {
      return state;
   }

   @Override
   public int compareTo(State o)
   {
      if(this.state.equals(o.state))
      {
         return 0;
      }
      else if(this.state.equals(NEW) || (this.state.equals(UPDATE) && o.state.equals(CANCELLED)))
      {
         return 1;
      }
      else
      {
         return -1;
      }
   }
}
