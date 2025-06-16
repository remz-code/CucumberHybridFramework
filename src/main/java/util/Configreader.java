package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader 
{
  public  Properties intializeProperties() throws IOException 
  {
	  Properties prop=new Properties();
	  File propFile=new File(System.getProperty("user.dir")+"/src/test/resources/cofig/config.properties");
	 // System.out.println(propFile);
	  FileInputStream fis = null;
	try {
		fis = new FileInputStream(propFile);
	} catch (FileNotFoundException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


		prop.load(fis);
        return prop;
  }
  
  
}
