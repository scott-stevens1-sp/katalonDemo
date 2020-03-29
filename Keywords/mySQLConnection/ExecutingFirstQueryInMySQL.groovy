package mySQLConnection

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import groovy.sql.Sql
import java.sql.*
public class ExecutingFirstQueryInMySQL {

	@Keyword
	//Creates connection
	public connection(String url, String user, String password, String driverClassName){

		def sqlConnection = Sql.newInstance(url, user, password, driverClassName)
		sqlConnection.eachRow("Show tables"){row ->
			println row[0]
		}
	}
	@Keyword
	//Creates Table
	public createTable(String url, String user, String password, String driverClassName){

		def sqlConnection = Sql.newInstance(url, user, password, driverClassName)

		def createSQLQuery = """Create Table personDetail(
				firstName varchar(50),lastName varchar(90))"""

		sqlConnection.execute(createSQLQuery)
		sqlConnection.eachRow("Describe personDetail"){row ->
			println "Column" + row[0] + "Type of column" + row[1]
		}
	}

	@Keyword
	//Creates Table
	public insertDataIntoTable(String url, String user, String password, String driverClassName){

		def sqlConnection = Sql.newInstance(url, user, password, driverClassName)
		/*
		 def createSQLQuery = """Create Table personDetail(
		 firstName varchar(50),lastName varchar(90))"""
		 */
		//sqlConnection.execute(createSQLQuery)
		sqlConnection.execute("Insert into personDetail (firstName,lastName) values ('Scott','Stevens')")
		sqlConnection.eachRow("Select * from personDetail"){row -> println "First Name = ${row[0]}, Last Name = ${row[1]}" }
	}
}

