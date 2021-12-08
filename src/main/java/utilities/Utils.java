package utilities;

import java.io.FileReader;
import java.util.Properties;

public class Utils {
    public static String getProperties(String property)  {
       String returnValue=null;
        try{
            FileReader reader=new FileReader("src/test/resources/properties/secret_keys.properties");
            Properties p=new Properties();
            p.load(reader);
           // System.out.println(p.getProperty(property));
            returnValue=p.getProperty(property);
           // logger.info("Secret Key file called for KEYS");
        }
        catch(Exception err){
            System.out.println(err);
        }

        return returnValue;

    }
}
