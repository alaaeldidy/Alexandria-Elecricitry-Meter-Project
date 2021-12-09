package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class Loadproperties
{
	public static Properties userdata =loadproperties(System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.properties");

	private static Properties loadproperties(String path)
	{
		Properties pro=new Properties(); 
		FileInputStream stream;
		try {
			stream = new FileInputStream(path);
			pro.load(stream);
		    }
			
			 catch (IOException e) 
		{
				 System.out.println("error.......file nor found" + e.getMessage() );
		} 
		
		 return pro;
				  
	}


}
