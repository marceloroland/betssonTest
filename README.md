
# 📱 Swag Labs Mobile Test Automation for Betsson Test

This project performs automated testing on the **Swag Labs** mobile app using **Java, Appium, Cucumber, TestNG, and Maven**.

---

## 🔧 Prerequisites

Before running the tests, make sure the following tools are installed and configured:

### 1. Java JDK
- Install JDK 11 or higher: [https://adoptium.net/](https://adoptium.net/)
- Verify installation:
  ```bash
  java -version
  ```

### 2. Android Studio
- Download and install Android Studio: [https://developer.android.com/studio](https://developer.android.com/studio)
- Set up a virtual Android emulator (AVD) with Android 16.0
- Set up Android emulator with this JSON config
  {
  "platformName": "Android",
  "appium:platformVersion": "16.0",
  "appium:deviceName": "androidPhone",
  "appium:automationName": "UiAutomator2",
  "appium:app": "\src\\test\\resources\\apk\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk",
  "appium:appPackage": "com.swaglabsmobileapp",
  "appium:appActivity": "com.swaglabsmobileapp.MainActivity",
  "appium:noReset": true
}

### 3. Node.js (Required for Appium)
- Download and install Node.js: [https://nodejs.org](https://nodejs.org)
- Verify:
  ```bash
  node -v
  ```

### 4. Appium
- Install Appium globally:
  ```bash
  npm install -g appium
  ```
- Start Appium server:
  ```bash
  appium
  ```

### 5. Maven
- Download and install Maven: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
- Verify:
  ```bash
  mvn -version
  ```

### 6. IntelliJ IDEA (Optional)
- Use IntelliJ IDEA to open and manage the project.
- Download: [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)

---

## 📁 Project Structure

```
betssonproject/
├── src/
│   ├── main/
│   │   └── java/
|   |
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   ├── hooks/
│       │   ├── pages/
│       │   ├── runners/
│       │   ├── steps/
│       └── resources/
│           └── features/
│               ├── login.feature
│               ├── logout.feature
│               ├── productDetails.feature
│               └── purchaseFlow.feature
└── pom.xml
```

---

## 🚀 How to Run the Tests

### 1. Open the Project
Open the project folder with IntelliJ IDEA or your preferred code editor.

### 2. Start the Emulator
Open Android Studio > Virtual Device Manager  
Start a device running Android 16.0.

### 3. Start the Appium Server
In your terminal:
```bash
appium
```

Wait for the message:
```
Appium REST http interface listener started on http://0.0.0.0:4723
```

### 4. Run the Tests
In the project root folder (where the `pom.xml` is located), run:
```bash
mvn clean test
```

---

## 🧪 Useful Commands

- Run all features with feature:
  ```bash
  mvn clean test
  ```

- View test results:
  After test execution, open:
  ```
  target/reports/cucumber-report.html
  ```

---

## 📋 Test Report

After running the tests, you can find the report files here:

```
target/reports/
├── cucumber-report.html
└── cucumber-report.json
```

---

## 📌 Technical Notes

- Driver initialization is handled in `BaseTest.java`
- All page classes inherit from `BasePage.java`
- Page interactions follow the **Page Object Model (POM)** structure
- Appium is used with the **UiAutomator2** driver
- Tests are written using **Gherkin syntax** (Cucumber)

---

## ❓ Support

If you need help running the project, contact marcelo.roland@outlook.com
