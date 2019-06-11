package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import model.Alarm;

class testAlarm
{
   @BeforeClass
   Alarm newAlarm = new Alarm("25", "processingError", "network failure", "new", "01-01-2019  10:20:00");
   
   @Test
   void test()
   {
      fail("Not yet implemented");
   }

}
