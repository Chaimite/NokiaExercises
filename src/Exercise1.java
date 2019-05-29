import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class Exercise1
{

   public static void main(String[] args)
   {
     
      Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
      String filePath =  path.toString() + "\\src\\alarms.csv";
      FileOutput fR = new FileOutput(filePath);

//     System.out.println(fR.getAlarmNumber(filePath));
//     System.out.println(fR.getAlarmStatus(filePath));
     ArrayList<String> gAS = fR.getAlarmStatus(filePath);
     ArrayList<String> gAN = fR.getAlarmNumber(filePath);

     System.out.println("Active alarms:");
     for(int i = 0; i< gAS.size();i++) {
        if(fR.isAlarmActive(gAS.get(i)) == true) {
           System.out.println(gAN.get(i));
     }

     }
   }

}
