package Utility.FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

  public static Properties readFromPropertiesFile(String fileName){

    File f = new File(fileName);
    String filePath = f.getAbsolutePath();
    FileInputStream fis = null;
    Properties prop = null;
    try {
      fis = new FileInputStream(filePath);
      prop = new Properties();
      prop.load(fis);
    } catch(Exception exception) {
      exception.printStackTrace();
      try {
        fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return prop;
  }
}
