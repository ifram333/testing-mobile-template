# Testing Mobile Template

This project contains a template for mobile test automation.

## Project technologies

The project is developed with the **Java** programming language and the **Appium** mobile automation framework.

- Java JDK 11

- Appium Server 1.22.3

- Maven

The following are the dependencies of the project:

| Dependency | Version |
|--|--|
| Cucumber Java | 7.8.1 |
| Cucumber TestNG | 7.8.1 |
| Cucumber Gherkin | 24.1.0 |
| TestNG | 7.6.1 |
| Appium Java | 8.2.0 |
| Selenium Java | 4.5.0 |
| Log4j Core | 2.19.0 |
| Log4J API | 2.19.0 |
| Slf4j API | 2.0.3 |
| Slf4j Simple | 2.0.3 |
| Allure Cucumber JVM | 2.19.0 |
| Guava | 31.1-jre |
| JSON | 20220924 |
| Tesseract | 5.4.0 |
| Joda Time | 2.12.1 |

## Project structure

The project is divided into modules to have a better control of its development in the different mobile OS and common
functionalities.

```
testing-mobile-template
│ pom.xml  

└─android
| | failedScenarios.xml
| | pom.xml
| | testng.xml
| └─src
|   └─test
|     └─java
|     | └─hooks
|     | | | AndroidHooks.java
|     | └─pages
|     | | | Page.java
|     | | | BasePage.java
|     | | | *Pages.java
|     | └─steps
|     | | | BaseSteps.java
|     | | | ClickSteps.java
|     | | | CompoundSteps.java
|     | | | SendKeysSteps.java
|     | | | SwipeSteps.java
|     | | | ValidationSteps.java
|     | | AndroidRunnerTest.java
|     | | FailedScenariosRunnerTest.java
|     └─resources
|       └─apps
|       | | *.apk
|       └─features
|         | *.features

└───utilities
| │ pom.xml
| └─src
|   └─main
|     └─java
|     |	└─appium
|     |	| │ AppiumServer.java
|     |	└─drivers
|     |	| │ AndroidAppDriver.java
|     |	| │ IOSAppDriver.java
|     |	└─extensions
|     |	| │ UiAutomator2Extension.java
|     |	| │ ExpectedConditionsExtension.java
|     |	| │ XCUITestExtension.java
|     |	└─helpers
|     |	| │ OCRHelper.java
|     |	| │ AllureHelper.java
|     |	└─readers
|     |	| │ AppiumJsonReader.java
|     |	| │ PropertiesReader.java
|     └─resources
|       │ appium.json
|       │ cucumber.properties
|       │ log4j2-test.xml

└─ios (Same structure as android module)

```

## Setting up the project before execution

The **appium.json** file located in the **/utilities/src/main/resources** path must be modified, since the
configurations to initialize the appium server and connect to the test device are loaded from it.

The **configs** section contains the paths where the **AndroidSDK**, **JDK**, **NodeJS**, the **Appium executable** are
installed and finally where the **appium logs** will be saved.

The way to add a new configuration is as follows:

Multiple configurations can be stored, since the execution of the project can be done on different computers or servers.

```json
"configs": {
   "config1": {
    "android": "/Path/to/Android/sdk",
    "java": "/Path/to/jdk/Contents/Home",
    "node": "/Path/to/node",
    "executable": "/Path/to/appium",
    "log": "target/appium.log"
  },
  "config2": {
    "android": "/Path/to/Android/sdk",
    "java": "/Path/to/jdk/Contents/Home",
    "node": "/Path/to/node",
    "executable": "/Path/to/appium",
    "log": "target/appium.log"
  }
}
```

The **servers** section is a list that contains the **config**, the **ip**, the **port**, the name of the **device** to load and the **
application** name to test.

Multiple servers can be stored, the user have to define which server will be executed.

> Note: If the port value is -1, appium will start in any free port available.

```json
"servers": [
  {
    "config": "config1",
    "ip": "0.0.0.0",
    "port": 4723,
    "device": "android-real",
    "app": "androidAppName",
    "device-name": "Samsung Galaxy S10",
    "device-os": "Android",
    "device-os-version": "12"
  },
  {
    "config": "config2",
    "ip": "0.0.0.0",
    "port": 4725,
    "device": "ios-simulator",
    "app": "iOSAppName",
    "device-name": "Google Pixel 4",
    "device-os": "Android",
    "device-os-version": "10"
  },
  {
    "config": "config1",
    "ip": "0.0.0.0",
    "port": -1,
    "device": "ios-simulator",
    "app": "secondAndroidApp",
    "device-name": "iPhone 14",
    "device-os": "iOS",
    "device-os-version": "16.1"
  }
]
```

> The **device-name**, **device-os** and **device-os-version** are information required for the allure report.

The **apps** section contains the name of the apps that will be tested with the project, these apps are stored in the **
/resources/apps** folder of their respective module. These apps are identified with a nickname.

> .apk apps are stored in /android/src/test/resources/apps

> .ipa apps are stored in /ios/src/test/resources/apps

```json
"apps": {
  "androidAppName": "testApp.apk",
  "secondAndroidApp": "testAppV2.apk",
  "iOSAppName": "testApp.ipa"
}
```

The **capabilities** section has the capabilities for the devices that will be used in the tests. These capabilities are
identified with a nickname.

```json
"capabilities": {
  "ios-simulator": {
    "platformVersion": "16.1",
    "deviceName": "iPhone 14"
  },
  "ios-real": {
    "platformVersion": "15.4",
    "deviceName": "iPhone XS Max",
    "udid": "XXXXXXXX-XXXXXXXXXXXXXXXX",
    "xcodeOrgId": "XXXXXXXXXX",
    "xcodeSigningId": "iPhone Developer"
  },
   "android-simulator": {
    "appium:avd": "Android_8",
    "appium:deviceName": "Android_8"
  },
  "android-real": {
    "appium:deviceName": "XXXXXXXXX"
  }
}
```

## To keep in mind before executing on MacOS

The Tesseract dependency has to be adequated to run on MacOS, follow the instructions below:

1. Install Tesseract on your MacOS

To install Tesseract, run the following command on your terminal:

`sudo port install tesseract`

For Brew users, run the command:

`brew install tesseract`

2. Go to the Tesseract maven folder

`cd /Users/%username%/.m2/repository/net/sourceforge/tess4j/tess4j/%version%`

> %username% is the name of the user registered on the MacOS

> %version% is the Tesseract's version number registered in the pom.xml file

3. Create a folder named 'darwin'

`mkdir darwin`

4. Update the .jar file corresponding to the Tesseract dependency adding the darwin folder into it

`jar uf tess4j-%version%.jar darwin`

> %version% is the Tesseract's version number registered in the pom.xml file

5. Copy the .dylib file downloaded in the first step into the darwin folder

`cp /usr/local/Cellar/tesseract/%version%/lib/libtesseract.%#%.dylib darwin/libtesseract.dylib`

> %version% is the Tesseract's version number downloaded in the first step

> %#% is the first number of the Tessearct's version number (e.g. 5)

6. Update the .jar file corresponding to the Tesseract dependency adding the .dylib file into it

`jar uf tess4j-%version%.jar darwin/libtesseract.dylib`

> %version% is the Tesseract's version number registered in the pom.xml file

7. Validate the .jar file has the darwin folder and the .dylib file on it

`jar tf tess4j-%version%.jar`

> %version% is the Tesseract's version number registered in the pom.xml file

If everything is ok, the last command will show the content table of the .jar file and we will be able to see the darwin folder and the .dylib file

```
META-INF/MANIFEST.MF
...
darwin/
darwin/libtesseract.dylib
```

## Executing the project

The project is executed through the following maven command called from the root folder (./testing-mobile-template/)

`mvn clean -pl %module% -am test -Dserver=%serverIndex%`

If the execution is to be done to a particular tag, the line -Dcucumber.filter.tags=@Test is added to the execution
command.

`mvn clean -pl %module% -am test -Dcucumber.filter.tags=@Test -Dserver=%serverIndex%`

In the event that the test execution fails, a **rerun.txt** file will be created in the target folder, this file will
save the failed cases so that they can be re-executed with the following command.

`mvn clean -pl %module% -am test -Dsuite=failedScenarios.xml -Dserver=%serverIndex%`

> %module% is the name of the module to execute (android/ios)

> %serverIndex% is the index of the server to load (this parameter is zero-indexed)

## Generating report

The project is executed through the maven command

The test report is generated with the following maven command, called from the required module folder (
./testing-mobile-template/android or ./testing-mobile-template/ios).

`mvn clean allure:report`

The report will be saved in the **target/reports/report** folder of the module where the command was called.
