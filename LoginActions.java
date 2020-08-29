package Org.SeleniumFramework.appModule;

import Org.SeleniumFramework.Constants.Constants;
import Org.SeleniumFramework.Reoprts.Log;
import Org.SeleniumFramework.Reoprts.Reports;
import Org.SeleniumFramework.Utility.Utility;

public class LoginActions extends Utility {
	
	public static boolean flag;
	
	public static boolean  login(String UN, String Pw) {
		 flag = false;
		
		 Log.info("UserName is :" + UN  + "Password is :" +Pw);
		 try {
			Utility.getLocator("Login_UserName_id").sendKeys(UN);
	
		 Log.info("UserName isEntered successfully");
		 Utility.getLocator("Login_Password_name").sendKeys(Pw);
		 Log.info("Password is Entered successfully");
		 Utility.getLocator("Login_Submit_button_ClassName").click();
		 Log.info("Submit button clicked successfully");
		 try {
			 Assert.assertequals(Constants.Config_Path)
		 }
		 flag = true;
		 }
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.info(e.fillInStackTrace().toString());
			
		
		
		
	}
		return flag;
  
}
	if (Utility.)
}
