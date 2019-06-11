package exercises;

import java.util.ArrayList;

import model.Alarm;
import model.State;
import util.FileOutput;

public class Exercise2 implements FilePath
{

   public static void main(String[] args)
   {
      // sorted array of Alarm: sorted by number int, not string
      // do a binary search to find a same alarm.
      // Implement comparable, to compare the time stamp in different alarms
      // Should the sorting be by int or by long? Would int loose
      // accuracy or overflow?
      // when found add the new state to the found alarm. do not create new
      // Alarm
      // probably array of states you will need in Alarm class.

      ArrayList<Alarm> alarms = FileOutput.getAlarmsFromFile(filePath);
      StringBuffer sb = new StringBuffer();
       
      for (Alarm alarm : alarms)
      {
         ArrayList<State> states = alarm.getStates();
         int statesCount = 0;
         sb.append(alarm.getAlarmNum());
         sb.append(";");
         sb.append(states.get(statesCount).getState());
         statesCount++;
         
         while(statesCount < states.size())
         {
            sb.append("->");
            sb.append(states.get(statesCount).getState());
            statesCount++;
         }
         System.out.println(sb.toString());
         sb.delete(0, sb.length());
      }
   }
}
