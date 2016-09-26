package LoggerExample;

import org.apache.log4j.Logger;

public class LoggerExampleOne {
	
	public static void main(String[] args) {
		
		Logger log1 = Logger.getLogger("devpinoyLogger");
		
		for(int i = 1; i<500; i++)
		{
			System.out.println("printing i: "+i);
			log1.fatal("Value of i : "+i);
		}
		
	}
	
	

}
