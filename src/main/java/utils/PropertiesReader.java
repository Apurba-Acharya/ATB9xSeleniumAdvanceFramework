package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String Key) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\APURBA ACHARYA\\IdeaProjects\\ATB9xSeleniumAdvanceFramework\\src\\main\\resources\\data.properties");
        //FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data.properties");
        Properties p = new Properties();
        p.load(fileInputStream);
        return p.getProperty(Key);

    }
}
