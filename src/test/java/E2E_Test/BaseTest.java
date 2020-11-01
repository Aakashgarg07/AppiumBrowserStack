package E2E_Test;

import Config.DataProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest extends DataProvider {
  public AndroidDriver<AndroidElement> driver;

  @BeforeMethod(alwaysRun = true)
  @Parameters(value={"deviceIndex"})
  public void setCapability(String deviceIndex) throws MalformedURLException {

    DesiredCapabilities cap = new DesiredCapabilities();

    HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
    browserstackOptions.put("appiumVersion", getAppiumVersion());
    cap.setCapability("bstack:options", browserstackOptions);
    cap.setCapability("app",getApp_url());
    cap.setCapability("deviceName", getDevices().get(Integer.parseInt(deviceIndex)));
    cap.setCapability("platformName", getPlatformName());
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,getAutomationName());
    cap.setCapability("platformVersion", getOsVersion().get(Integer.parseInt(deviceIndex)));

    driver = new AndroidDriver<AndroidElement>(
        new URL("https://"+getBrowserStackUser()+":"+getBrowserStackKey()+"@hub-cloud.browserstack.com/wd/hub"), cap);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }


  @AfterMethod(alwaysRun = true)
  public void tearDown(){
    driver.quit();
 }


}
