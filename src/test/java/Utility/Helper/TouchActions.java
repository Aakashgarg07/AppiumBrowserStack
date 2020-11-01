package Utility.Helper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class TouchActions {
  static AndroidTouchAction touchAction;
  public static void longPress(AndroidDriver driver, WebElement ele, long timeInSec){
    touchAction = new AndroidTouchAction(driver);
    touchAction.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(timeInSec))).release().perform();
  }

  public static void swipe(AndroidDriver driver, WebElement src, WebElement tar){
    touchAction = new AndroidTouchAction(driver);
    touchAction.longPress(longPressOptions().withElement(element(src)).withDuration(ofSeconds(2))).moveTo(element(tar)).release().perform();


  }

}
