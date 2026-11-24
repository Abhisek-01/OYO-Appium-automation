package appium.tests;

import org.testng.annotations.Test;

import appium.base.BaseTest;
import appium.pages.OnboardingPage;
import appium.pages.NavSidebar;

public class AppLaunchTest extends BaseTest{
	
	@Test(enabled = false)
	public void verifyAppLunch() {
		
		System.out.println("Application launched!");

        System.out.println("Package: " + driver.getCurrentPackage());

        System.out.println("Activity: " + driver.currentActivity());
        
	}
	
	@Test
	public void TestApp(){

		System.out.println("Application launched!");

		OnboardingPage onboarding = new OnboardingPage(driver);
		onboarding.completeOnboarding();

		NavSidebar navSidebar = new NavSidebar(driver);
		navSidebar.completeNavSidebar();

	}
	
}
