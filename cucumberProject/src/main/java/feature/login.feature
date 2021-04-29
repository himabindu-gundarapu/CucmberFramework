#without Examples Keyword
Feature:  Feature
Scenario: SalesFroce Login Test Scenario

Given user is already on Login Page
When title of login page is Salesforce
Then user enters "himabindu@sbn.com" and "Salesforce@2021"
Then user clicks on login button
Then user is on home page
Then close the browser	