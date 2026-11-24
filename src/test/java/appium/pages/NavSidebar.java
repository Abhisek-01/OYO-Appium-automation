package appium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class NavSidebar {

	private AndroidDriver driver;
	private WebDriverWait wait;

	// Common locators
	private By sidebarMenu = By.xpath("(//android.view.View[@resource-id=\"com.oyo.consumer:id/oyo_icon_view\"])[1]");
	private By navBack = By.xpath("//android.widget.ImageView[@resource-id=\"com.oyo.consumer:id/navigationIcon\"]");
	private By changeLanBack = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	// Guest Nav
	private By guestNav = By.xpath("//android.widget.ImageView[@resource-id=\"com.oyo.consumer:id/iv_hnh_user\"]");
	private By enterNumber = By.xpath("//android.widget.EditText[@resource-id=\"com.oyo.consumer:id/et_phone_number\"]");

	// OYO Wizard
	private By oyoWizard = By.xpath("//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_wizard_layout\"]");
	private By silverTab = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.oyo.consumer:id/tab_header\"])[2]");
	private By goldTab = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.oyo.consumer:id/tab_header\"])[3]");
	private By closeWizard = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.oyo.consumer:id/end_icon_container\"]/android.view.View[2]");

	// OYO Holiday
	private By oyoHoliday = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[1]");
	private By holidayName = By.xpath("//android.widget.EditText[@resource-id=\"nameDesktop\"]");
	private By destination = By.xpath("//android.view.View[@resource-id=\"destinationDesktop\"]");
	private By kashmirOption = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Kashmir\"]");
	private By holidayNumber = By.xpath("//android.widget.EditText[@resource-id=\"contactDesktop\"]");
	private By emailField = By.xpath("//android.widget.TextView[@text=\"What drives us\"]");

	// Other nav items
	private By inviteAndEarn = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[2]");
	private By viewWallets = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.oyo.consumer:id/item_container\"])[3]/android.view.ViewGroup/android.view.ViewGroup");
	private By savedOyo = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[3]");
	private By bookEvents = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[4]");
	private By needHelp = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[5]");
	private By changeLanguage = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[6]");
	private By viewPrivacyPolicy = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[7]");
	private By travelAgentPartner = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[8]");
	private By oyoForBusiness = By.xpath("(//android.view.ViewGroup[@resource-id=\"com.oyo.consumer:id/navbar_list_item\"])[9]");

	public NavSidebar(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// ---- Helper methods ----

	private void openSidebar() {
		wait.until(ExpectedConditions.elementToBeClickable(sidebarMenu));
		driver.findElement(sidebarMenu).click();
		System.out.println("Opened sidebar menu.");
	}

	private void goBack() {
		wait.until(ExpectedConditions.elementToBeClickable(navBack));
		driver.findElement(navBack).click();
		System.out.println("Navigated back.");
	}

	// ---- Sidebar flows ----

	public void guestNavFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(guestNav));
			driver.findElement(guestNav).click();
			System.out.println("Clicked Guest Nav.");

			wait.until(ExpectedConditions.elementToBeClickable(enterNumber));
			driver.findElement(enterNumber).sendKeys("98978946235791");
			System.out.println("Entered phone number.");

			goBack();
		} catch (Exception e) {
			System.out.println("Guest Nav flow failed: " + e.getMessage());
		}
	}

	public void oyoWizardFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(oyoWizard));
			driver.findElement(oyoWizard).click();
			System.out.println("Clicked OYO Wizard.");

			wait.until(ExpectedConditions.elementToBeClickable(silverTab));
			driver.findElement(silverTab).click();
			System.out.println("Clicked Silver tab.");

			wait.until(ExpectedConditions.elementToBeClickable(goldTab));
			driver.findElement(goldTab).click();
			System.out.println("Clicked Gold tab.");

			wait.until(ExpectedConditions.elementToBeClickable(closeWizard));
			driver.findElement(closeWizard).click();
			System.out.println("Closed Wizard.");
		} catch (Exception e) {
			System.out.println("OYO Wizard flow failed: " + e.getMessage());
		}
	}

	public void oyoHolidayFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(oyoHoliday));
			driver.findElement(oyoHoliday).click();
			System.out.println("Clicked OYO Holiday.");

			wait.until(ExpectedConditions.elementToBeClickable(holidayName));
			driver.findElement(holidayName).sendKeys("Test User");
			System.out.println("Entered name.");

			wait.until(ExpectedConditions.elementToBeClickable(destination));
			driver.findElement(destination).click();
			System.out.println("Clicked destination.");

			wait.until(ExpectedConditions.elementToBeClickable(kashmirOption));
			driver.findElement(kashmirOption).click();
			System.out.println("Selected Kashmir.");

			wait.until(ExpectedConditions.elementToBeClickable(holidayNumber));
			driver.findElement(holidayNumber).sendKeys("98978946235791");
			System.out.println("Entered phone number.");

			wait.until(ExpectedConditions.elementToBeClickable(emailField));
			driver.findElement(emailField).sendKeys("testuser@example.com");
			System.out.println("Entered email.");

			// Scroll the page to complete down
			driver.executeScript("mobile: scrollGesture", java.util.Map.of(
				"left", 100, "top", 500, "width", 800, "height", 1000,
				"direction", "down", "percent", 1.0
			));
			System.out.println("Scrolled page down.");

			goBack();
		} catch (Exception e) {
			System.out.println("OYO Holiday flow failed: " + e.getMessage());
		}
	}

	public void inviteAndEarnFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(inviteAndEarn));
			driver.findElement(inviteAndEarn).click();
			System.out.println("Clicked Invite & Earn.");

			goBack();
		} catch (Exception e) {
			System.out.println("Invite & Earn flow failed: " + e.getMessage());
		}
	}

	public void viewWalletsFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(viewWallets));
			driver.findElement(viewWallets).click();
			System.out.println("Clicked View Wallets.");

			goBack();
		} catch (Exception e) {
			System.out.println("View Wallets flow failed: " + e.getMessage());
		}
	}

	public void savedOyoFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(savedOyo));
			driver.findElement(savedOyo).click();
			System.out.println("Clicked Saved OYO.");

			goBack();
		} catch (Exception e) {
			System.out.println("Saved OYO flow failed: " + e.getMessage());
		}
	}

	public void bookEventsFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(bookEvents));
			driver.findElement(bookEvents).click();
			System.out.println("Clicked Book Events.");

			goBack();
		} catch (Exception e) {
			System.out.println("Book Events flow failed: " + e.getMessage());
		}
	}

	public void needHelpFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(needHelp));
			driver.findElement(needHelp).click();
			System.out.println("Clicked Need Help.");

			goBack();
		} catch (Exception e) {
			System.out.println("Need Help flow failed: " + e.getMessage());
		}
	}

	public void changeLanguageFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(changeLanguage));
			driver.findElement(changeLanguage).click();
			System.out.println("Clicked Change Language.");

			driver.findElement(changeLanBack).click();
		} catch (Exception e) {
			System.out.println("Change Language flow failed: " + e.getMessage());
		}
	}

	public void viewPrivacyPolicyFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(viewPrivacyPolicy));
			driver.findElement(viewPrivacyPolicy).click();
			System.out.println("Clicked View Privacy Policy.");

			goBack();
		} catch (Exception e) {
			System.out.println("View Privacy Policy flow failed: " + e.getMessage());
		}
	}

	public void travelAgentPartnerFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(travelAgentPartner));
			driver.findElement(travelAgentPartner).click();
			System.out.println("Clicked Travel Agent Partner.");

			goBack();
		} catch (Exception e) {
			System.out.println("Travel Agent Partner flow failed: " + e.getMessage());
		}
	}

	public void oyoForBusinessFlow() {
		try {
			openSidebar();

			wait.until(ExpectedConditions.elementToBeClickable(oyoForBusiness));
			driver.findElement(oyoForBusiness).click();
			System.out.println("Clicked OYO for Business.");

			goBack();
		} catch (Exception e) {
			System.out.println("OYO for Business flow failed: " + e.getMessage());
		}
	}

	// ---- Run all sidebar flows ----

	public void completeNavSidebar() {
		try {
			guestNavFlow();
			oyoWizardFlow();
			oyoHolidayFlow();
			inviteAndEarnFlow();
			viewWalletsFlow();
			savedOyoFlow();
			bookEventsFlow();
			needHelpFlow();
			changeLanguageFlow();
			viewPrivacyPolicyFlow();
			travelAgentPartnerFlow();
			oyoForBusinessFlow();
			System.out.println("All sidebar flows completed.");
		} catch (Exception e) {
			System.out.println("NavSidebar failed: " + e.getMessage());
		}
	}

}
