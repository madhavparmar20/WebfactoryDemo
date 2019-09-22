package common;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected abstract void startservice();
	protected abstract void stopservice();
	protected abstract void createDriver();
	protected WebDriver driver;
	
	public void quitDriver() {
		
		if(null!=driver) {
			
			driver.quit();
			driver = null;
			
			}
	}
		
		public WebDriver getDriver() {
			
			if(null==driver) {
				
				startservice();
				createDriver();
			}
			return driver;
		}
	}


