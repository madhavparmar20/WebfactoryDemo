package common;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class ChromeDriverManager extends DriverManager {
	
	private ChromeDriverService chservice;
	
	@Override
	public void startservice() {
		
		if (null==chservice) {
			
			try {
			
			chservice=new ChromeDriverService.Builder().usingDriverExecutable(new File("G:\\Jars\\selenium_jar\\chromedriver.exe")).usingAnyFreePort().build();
			chservice.start();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	}
	
	@Override
	public void stopservice() {
		
		if(null!= chservice && chservice.isRunning())
			chservice.stop();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void createDriver() {
		
		DesiredCapabilities capabilities =DesiredCapabilities.chrome();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY,options);
		driver=new ChromeDriver(chservice,capabilities);
		
		
	}
	
}


	