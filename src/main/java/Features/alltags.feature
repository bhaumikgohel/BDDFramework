@FunctionalTest
Feature: Free CRM Testing Site
  @SmokeTest
  Scenario: Check Free CRM Site for End to End FUnctionality
  Given check free crm site
  
  @SmokeTest @RegressionTest
  Scenario: Check create contact FUnctionality
  Given check creaet conatct Functionality Test
  
  @SmokeTest @End2End
  Scenario: Check create deal FUnctionality
  Given check creaet deal Functionality Test
  
  @SmokeTest @End2End
  Scenario: Check deal FUnctionality
  Given Verify creaet deal Functionality Test
  
  @SmokeTest @RegressionTest
  Scenario: Check Company FUnctionality
  Given check creaet Company Functionality Test
  
  @RegressionTest
  Scenario: Verify Company FUnctionality
  Given Verify Company data Functionality Test