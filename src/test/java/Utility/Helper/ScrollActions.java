package Utility.Helper;

import io.appium.java_client.android.AndroidDriver;

public class ScrollActions {

  public static void scrollIntoView(AndroidDriver driver, String text){
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
  }
}
