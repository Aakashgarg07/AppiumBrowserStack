package Config;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static Utility.FileReader.PropertyReader.readFromPropertiesFile;
import static Utility.Helper.AppUploadINBrowserStack.getAppPathFromBrowserStack;


public class DataProvider {

  private static String browserStackUser;
  private static String browserStackKey;
  private static String app_url;
  private static List<String> devices;
  private static String automationName;
  private static List<String> osVersion;
  private static String platformName;
  private static String appiumVersion;


  public DataProvider(){
    Properties prop = readFromPropertiesFile("src/test/resources/Properties/config.properties");
    this.browserStackKey=System.getProperty("browserStackKey");
    this.browserStackUser=System.getProperty("browserStackUser");
    this.app_url=getAppPathFromBrowserStack(browserStackUser,browserStackKey);
    this.devices = Arrays.asList(prop.getProperty("devices").split(","));
    this.osVersion=Arrays.asList(prop.getProperty("osVersion").split(","));
    this.automationName=prop.getProperty("automationName");
    this.platformName=prop.getProperty("platformName");
    this.appiumVersion=prop.getProperty("appiumVersion");
  }

  public static String getBrowserStackUser() {
    return browserStackUser;
  }

  public static String getBrowserStackKey() {
    return browserStackKey;
  }

  public static String getPlatformName() {
    return platformName;
  }

  public static String getAppiumVersion() {
    return appiumVersion;
  }
  public static String getApp_url() {

    return app_url;
  }

  public static List<String> getDevices() {
    return devices;
  }

  public static String getAutomationName() {
    return automationName;
  }

  public static List<String> getOsVersion() {
    return osVersion;
  }




}

