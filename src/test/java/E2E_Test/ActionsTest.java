package E2E_Test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Utility.Helper.ScrollActions.scrollIntoView;
import static Utility.Helper.TouchActions.longPress;
import static Utility.Helper.TouchActions.swipe;

public class ActionsTest extends BaseTest{

  @Test
  public void  performLongPressGesture() throws InterruptedException {
    //views --> Expandable List --> Custom Adapter --> people Names --> Long Press --> Sample menu
    driver.findElementByXPath("//*[contains(@text,'Views')]").click();
    driver.findElementByXPath("//*[contains(@text,'Expandable Lists')]").click();
    driver.findElementByXPath("//*[contains(@text,'Custom Adapter')]").click();
    WebElement ele = driver.findElementByXPath("//*[contains(@text,'People Names')]");
    longPress(driver,ele,4);
    Assert.assertTrue(driver.findElementByXPath("//*[contains(@text,'Sample menu')]").isDisplayed());
  }

  @Test
  public  void swipeTime(){
    driver.findElementByXPath("//*[contains(@text,'Views')]").click();
    driver.findElementByXPath("//*[contains(@text,'Date Widgets')]").click();
    driver.findElementByXPath("//*[contains(@text,'2. Inline')]").click();
    driver.findElementByAccessibilityId("9").click();
    WebElement src= driver.findElementByAccessibilityId("45");
    WebElement tar =  driver.findElementByAccessibilityId("15");
    swipe(driver,src,tar);
  }

  @Test
  public void scrollPage(){
    driver.findElementByAccessibilityId("Views").click();
    scrollIntoView(driver,"WebView");
  }
}
