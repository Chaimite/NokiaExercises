package model;

import java.util.ArrayList;
import java.util.Collections;

public class Alarm implements Comparable<Alarm>
{
   private int alarmNum;
   private String type;
   private String text;
   private ArrayList<State> states;

   public Alarm(String alarmNum, String type, String text, String state,
         String timeStamp)
   {
      super();
      setAlarmNum(alarmNum);
      this.type = type;
      this.text = text;
      
      states = new ArrayList<State>();
      states.add(new State(state, timeStamp));
   }
   
   public Alarm(String alarmNum)
   {
      super();
      setAlarmNum(alarmNum);
   }

   public String getAlarmNum()
   {
      return alarmNum + "";
   }

   public void setAlarmNum(String alarmNum)
   {
      this.alarmNum = Integer.parseInt(alarmNum);
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
   
   public void addState(String state, String timeStamp)
   {
      states.add(new State(state, timeStamp));
      Collections.sort(states);
   }
   
   public void setText(String text)
   {
      this.text = text;
   }

   // Method to check the state of an alarm
   public boolean isActive()
   {
      State s = getLatestState();
      
      return !s.getState().equals("cancelled");
   }
   
   public ArrayList<State> getStates()
   {
      return states;
   }
   
   public State getLatestState()
   {
      if(!states.isEmpty())
      {
         return states.get(states.size() - 1);
      }
      return null;
   }

   @Override
   public int compareTo(Alarm o)
   {
      if(this.alarmNum == o.alarmNum)
      {
         return 0;
      }
      else if(this.alarmNum < o.alarmNum)
      {
         return -1;
      }
      else
      {
         return 1;
      }
   }
}
