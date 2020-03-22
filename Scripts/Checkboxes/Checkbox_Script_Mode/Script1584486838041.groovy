import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('http://www.executeautomation.com/demosite/index.html?UserName=&Password=&Login=Login')

WebUI.delay(5)

if (WebUI.verifyElementNotChecked(findTestObject('Object Repository/ExecuteAutomationLogin/HindiCheckbox'), 1)) {
    WebUI.check(findTestObject('Object Repository/ExecuteAutomationLogin/HindiCheckbox'))

    WebUI.comment('Hindi Box Checked')
}

WebUI.delay(5)

if (WebUI.verifyElementChecked(findTestObject('Object Repository/ExecuteAutomationLogin/HindiCheckbox'), 2)) {
    WebUI.uncheck(findTestObject('Object Repository/ExecuteAutomationLogin/HindiCheckbox'))

    WebUI.comment('Hindi Box Un-Checked')
}

