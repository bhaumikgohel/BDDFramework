Feature: Validate Deal Functionality

Scenario: Enter Deal Details
    Given user is on credential page
    And user enter username and password
    | username | password |
    | bhaumik@yopmail.com | Admin@123123 |
    And user move to home page and deal link and click on it
    And user enter deal details
    | Title | Description | Probability |
    | Bhaumik | Gohel | 80 |
    | Asha | Gohel | 20 |
    | Mahesh | Patel | 30 |
    Then user click on save button
    Then user close the browser