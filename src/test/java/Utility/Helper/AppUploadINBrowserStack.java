package Utility.Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class AppUploadINBrowserStack {

    public static String getAppPathFromBrowserStack (String username, String key) {

    String appPath="./src/test/resources/APK/ApiDemos-debug.apk";

    RestAssured.baseURI = "https://api-cloud.browserstack.com/app-automate/upload";
      Response response =
          RestAssured.given().auth().preemptive().basic(username, key).
          contentType("multipart/form-data").multiPart(new File(appPath)).post();

      return response.jsonPath().getString("app_url");


    }
  }

