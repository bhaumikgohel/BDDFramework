
Feature: Create new Contacts

  Scenario Outline: User check new conact Test Scenario
    Given User is alreadyon Login page
    When tile of login page is FreeCRM
    Then User enters "<username>" and "<password>"
    Then user clickon login button
    Then user on home page
    Then user move to the new contact page
    Then user enter "<firstname>" and "<lastname>"
    Then close the browser

    Examples: 
     | username | password | firstname | lastname |
     | bhaumik@yopmail.com | Admin@123123 | Bhaumik | Gohel |
     | bhaumik@yopmail.com | Admin@123123 | Pooja | K |
     | bhaumik@yopmail.com | Admin@123123 | Jay | J |
