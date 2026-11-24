package appium.utils;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppUtils {

	private AndroidDriver driver;
	private WebDriverWait wait;

	public AppUtils(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void safeClick(By locator, String description) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			element.click();
			System.out.println(description + " - clicked.");
		} catch (Exception e) {
			System.out.println(description + " - click failed, trying tap...");
			try {
				WebElement element = driver.findElement(locator);
				int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
				int y = element.getLocation().getY() + element.getSize().getHeight() / 2;
				driver.executeScript("mobile: clickGesture", Map.of("x", x, "y", y));
				System.out.println(description + " - tapped.");
			} catch (Exception e2) {
				System.out.println(description + " - failed: " + e2.getMessage());
			}
		}
	}

	public void safeClick(By locator, By fallbackLocator, String description) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).click();
			System.out.println(description + " - clicked.");
		} catch (Exception e) {
			System.out.println(description + " - trying fallback...");
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(fallbackLocator));
				driver.findElement(fallbackLocator).click();
				System.out.println(description + " - fallback clicked.");
			} catch (Exception e2) {
				System.out.println(description + " - failed: " + e2.getMessage());
			}
		}
	}

	public void safeSendKeys(By locator, String text, String description) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).sendKeys(text);
			System.out.println(description + " - entered text.");
		} catch (Exception e) {
			System.out.println(description + " - failed: " + e.getMessage());
		}
	}

}
