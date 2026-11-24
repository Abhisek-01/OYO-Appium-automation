package appium.pages;

import org.openqa.selenium.By;

import appium.utils.AppUtils;
import io.appium.java_client.android.AndroidDriver;

public class OnboardingPage {

	private AppUtils utils;

	// Locators
	private By continueBtn = By.xpath("//android.widget.TextView[@resource-id=\"com.oyo.consumer:id/tvTxt\"]");
	private By denyLocationBtn = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]");
	private By signupLaterBtn = By.xpath("//android.widget.TextView[@resource-id=\"com.oyo.consumer:id/tvTxt\" and @text=\"I'll signup later\"]");
	private By signupLaterFallback = By.xpath("//android.widget.TextView[contains(@text,'signup later')]");
	private By notifyDonotallow = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]");

	public OnboardingPage(AndroidDriver driver) {
		this.utils = new AppUtils(driver);
	}

	public void completeOnboarding() {
		try {
			utils.safeClick(continueBtn, "Continue button");
			utils.safeClick(denyLocationBtn, "Deny location");
			Thread.sleep(5000);
			utils.safeClick(signupLaterBtn, signupLaterFallback, "Signup later");
			utils.safeClick(notifyDonotallow, "Notification denied");
		} catch (Exception e) {
			System.out.println("Onboarding failed: " + e.getMessage());
		}
	}

}
