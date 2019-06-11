package exercises;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public interface FilePath
{
   public static final Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
   public static final String filePath = path.toString() + "\\src\\alarms.csv";
}
