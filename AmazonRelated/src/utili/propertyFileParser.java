package utili;


import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;

public class propertyFileParser{
	
	public static String propReadMethod(String prprtyKey)
	{
		//used to parse the values from the properties file written using key/value combination
		String prprtyValue = "";
		try
		{
			FileInputStream fis = new FileInputStream("./testdata/testRelatedData.properties");
			Properties prop = new Properties();
			prop.load(fis);
			prprtyValue = prop.getProperty(prprtyKey);
		}
		catch (Exception e)
		{
			Reporter.log("[Guru] Loading of property file failed. \n "+e.getMessage());
			
		}
		return prprtyValue;
	}
	
	

}
