package util;


import java.util.Date;

public class Commonutils {
	public static final int IMPICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_TIME=30;
	
	public  String getEmailwithTimeStamp()
	{
		Date date=new Date();
		return "remz"+date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";
		
	}

}
