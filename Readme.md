# Folder Structure 

1\) Config 
```
 Will read data from property file present in resources directory
```

2\) E2E Test 
```
Have two Classes 
1) Base test --> Will set capapbility based on data provider and suite file.
Have After method  -- which will close the driver session after test run

2) Action test --> Have Three test (Long press , Swipe and Scroll)

```

3\) Utility 
```
Will be having helper and resuable methods
```

4\) Resources
```
Will be having APK file and other resources like config.property file
```

#To Run all test case in single Device 

```
mvn clean test -P SingleDevice -DbrowserStackUser='' -DbrowserStackKey=''
```

#To Run all test case in Multiple Device 

```
mvn clean test -P MultiDevice -DbrowserStackUser='' -DbrowserStackKey=''
```

Working

```
1) Data provider class reads all capability from property file

2) For App upload to Browser Stack --> have used Rest assured client 
(Helper method --> AppUploadINBrowserStack class)

3) In suite XML  can set different devices 
based on value 0 --> Google Pixel 3 (will be selected)
as in property file i am passing list of devices 

devices=Google Pixel 3,Samsung Galaxy S10e

cap.setCapability("deviceName", getDevices().get(Integer.parseInt(deviceIndex)));


```


