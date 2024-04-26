# Chrome-Extension-Automation-Testing
##  Automation of Chrome Extension with Selenium

# Youtube recording links
- [Structure and Approach for Framework-Walkthorough](https://www.youtube.com/watch?v=i1r9rN8Je5M)
- [Test Run and test reports](https://www.youtube.com/watch?v=vNmiUvb_Hf8)

# Excel Sheet list
- [View excelSheet](https://github.com/Ninja-Cyborg/Chrome-Extension-Automation-Testing/blob/main/Chrome-Extension-Automation/webapptestproject/src/main/resources/testCases.xlsx)

# Approach
- This project follows Data driven approach
- To run tests for specific extensions, the changes can be made in key-value pairs in testng_suite.xml file
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
- Run following file as TestNg suite from IDE:  testng_suite.xml 

# Modifying testCase
- you can change the values for browser, extensionName from testng_suite.xml file

# Limitations
- To get the dynamic component(inline-card) from shadom-DOM : The step has been hard-coded to hover over test to show inline-card
- For the same reason the negative and postive tests can not run parrallel on same machine
- Moreover, Grammarly website stats the support for Google Docs. But, it requires additional step to sign-in. I deemed that as out of scope for the project, and choose not to implement. Instead used online text editor to verify extension's feature.

# HTML Reports
- [EXTENT REPORTS](https://github.com/Ninja-Cyborg/Chrome-Extension-Automation-Testing/tree/main/Chrome-Extension-Automation/webapptestproject/test-output/ExtentReport)
- ![image](https://user-images.githubusercontent.com/66517017/209552622-e71b8bbd-69a1-4356-a140-79147e364e29.png)

