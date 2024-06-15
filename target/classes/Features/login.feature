Feature: Free CRM Login Feature

#Without Example Keyword of login
  #Scenario: User Login Test Scenario
    #Given User is already on Login page
    #When tile of login page is Free CRM
    #When User enter "bhaumik@yopmail.com" and "Admin@123123"
    #Then user click on login button
    #And user is on home page
    #Then browser is close

#with example keyword login into system
  Scenario Outline: User Login Test Scenario
    Given User is already on Login page
    When tile of login page is Free CRM
    Then User enter "<username>" and "<password>"
    Then user click on login button
    And user is on home page
    Then browser is close
    
    Examples:
    | username | password |
    | bhaumik@yopmail.com | Admin@123123 |
    | Akshay | Admin@123 |
    