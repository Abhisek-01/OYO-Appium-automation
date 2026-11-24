package appium.base;
import org.testng.annotations.BeforeMethod;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	protected AndroidDriver driver;
	
	@BeforeMethod
	public void setup() throws Exception {
		
		UiAutomator2Options options = new UiAutomator2Options();
		
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");
        
        options.setUdid("emulator-5554");
        
        options.setAppPackage("com.oyo.consumer");
        options.setAppActivity("com.oyo.consumer.activity.LauncherActivity");
        options.setCapability("appium:adbExecTimeout", 60000);
        
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"),options);
        
        System.out.println("Appium connection successful!");
		
	}
	

}
