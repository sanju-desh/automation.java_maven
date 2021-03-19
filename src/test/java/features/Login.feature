Feature: Application Login

  Scenario Outline: Login and check home page
    Given Launch the web application in browser
    When Enter <UserName> and <Password>
    And Click login button
    Then Home page should be displayed
    And username should be displayed

    Examples:
      |UserName|Password|
      |christoph.ss@hotmail.com|Pulsar#123|
      |sanju.desh@gmail.com    |Bistro@2016|