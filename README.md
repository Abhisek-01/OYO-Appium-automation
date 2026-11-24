# OYO Appium Mobile Automation Framework

An automated end-to-end mobile testing framework built with **Appium (Java Client)**, **Selenium**, and **TestNG** targeting the **OYO Consumer Android Application** (`com.oyo.consumer`). Designed with the **Page Object Model (POM)** for scalability, maintainability, and reusability.

---

## 📱 Project Overview

This repository automates critical user journeys and navigation flows across the OYO Android application, including onboarding handling, runtime permissions, and sidebar navigation menus.

### Key Highlights
- **Page Object Model (POM)**: Segregation of locators and business workflows into modular page classes.
- **Resilient Element Interactions**: Custom helper utilities (`AppUtils`) featuring explicit waits (`WebDriverWait`), locator fallbacks, and gesture-based fallback click strategies (`mobile: clickGesture`).
- **Comprehensive Flow Coverage**: Automated tests for user onboarding, location/notification permission handling, guest login, holiday inquiries, and full navigation sidebar validation.

---

## 🏗️ Architecture & Directory Structure

```text
MobileAutomate/
├── src/
│   └── test/
│       └── java/
│           └── appium/
│               ├── base/
│               │   └── BaseTest.java        # Driver initialization, UiAutomator2 setup & capabilities
│               ├── pages/
│               │   ├── OnboardingPage.java  # Permission dialogues, onboarding skip flows
│               │   └── NavSidebar.java      # Sidebar actions & navigation flows
│               ├── tests/
│               │   └── AppLaunchTest.java   # TestNG test suites executing end-to-end scenarios
│               └── utils/
│                   └── AppUtils.java        # Resilient click, tap gesture, & input helpers
├── pom.xml                                  # Maven dependencies & build configuration
└── README.md
```

---

## ⚙️ Tech Stack & Dependencies

- **Java**: JDK 17
- **Build Tool**: Apache Maven
- **Automation Driver**: [Appium Java Client](https://github.com/appium/java-client) (`11.0.0`)
- **Web/Mobile Driver Core**: Selenium Java (`4.50.0`)
- **Test Runner & Assertions**: TestNG (`7.11.0`)
- **Android Automation Engine**: UiAutomator2

---

## 🚀 Automated Scenarios

### 1. Onboarding & Permissions (`OnboardingPage.java`)
- Handles system location permission prompts (deny/allow).
- Handles notification runtime permission prompts.
- Handles "I'll signup later" flow to proceed directly to the home screen.

### 2. Navigation Sidebar Modules (`NavSidebar.java`)
- **Guest Login / Account**: Enters phone number flow.
- **OYO Wizard**: Interacts with loyalty tiers (Silver, Gold) and modal transitions.
- **OYO Holidays**: Fills out inquiry form (destination selection, contact details, email) and executes W3C scroll gestures (`mobile: scrollGesture`).
- **Additional Navigation Sections**:
  - Invite & Earn
  - View Wallets
  - Saved OYO
  - Book Events
  - Need Help / Support
  - Change Language
  - Privacy Policy
  - Travel Agent Partner
  - OYO for Business

---

## 🛠️ Prerequisites & Setup

1. **Java Development Kit (JDK 17+)**
   - Ensure `JAVA_HOME` is set and added to your `PATH`.
2. **Android SDK & Emulator / Real Device**
   - Ensure `ANDROID_HOME` is set.
   - Verify connected devices:
     ```bash
     adb devices
     ```
3. **Appium 2.x Server**
   - Install Appium and UiAutomator2 driver:
     ```bash
     npm install -g appium
     appium driver install uiautomator2
     ```
   - Start the Appium server:
     ```bash
     appium
     ```
4. **OYO Consumer App**
   - Package: `com.oyo.consumer`
   - Launcher Activity: `com.oyo.consumer.activity.LauncherActivity`

---

## 🧪 Running the Tests

To run the automated tests via Maven:

```bash
mvn clean test
```

Or run directly through TestNG inside Eclipse / IntelliJ IDEA by right-clicking `AppLaunchTest.java` -> **Run As** -> **TestNG Test**.
