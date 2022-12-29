# Chrome-Extension-Automation-Testing
##  Automation of Chrome Extension with Selenium

# ScreenCast of running Tests and report
- [Framework-Walkthorough]()
- [Test Run](https://youtu.be/uFhx0TH_fas)

# Approach
- I followed Data driven approach
- TO run tests for specific extensions, the changes can be made in key-value pairs in testng_suite.xml file
- To test Grammarly extension, first browser validates if it exists for browser
- Then the installation involves javascript popups, which are handles by js query

# Test-Cases
- Verify if installed: validateIfExtensionInstalled
- Positive Test Case: checkForErrorReplament
- Negative Test Case: validateLanguageErrorAreNotDetected

# Learnings/Challenges
## The Grammarly Extension elements located in Shadom DOM
- Implemented javascript query: to access the data within shadom-DOM components
- Used Robot class to hover over text, to interact with dynamic componenets

# Running test cases:
- Run following file as TestNg_suite:  testng_suite.xml 

# Modifying testCase
- you can change the values for browser, extensionName from testng_suite.xml file

# Limitations
- The basic installation process for all extensions are same. So, chromeWebStorePageTest and ExtentionPage will validate all Chrome WebStore Extensions
- To get the dynamic component(inline-card) from shadom-DOM : The code to hover over test to show inline-card is hard-coded.


# HTML Reports
- [EXTENT REPORTS](https://github.com/Ninja-Cyborg/Chrome-Extension-Automation-Testing/tree/main/Chrome-Extension-Automation/webapptestproject/test-output/ExtentReport)
- ![image](https://user-images.githubusercontent.com/66517017/209552622-e71b8bbd-69a1-4356-a140-79147e364e29.png)

## Ps: The recorded video was in mkv format, i will update with higher mp4 as soon as possible.
