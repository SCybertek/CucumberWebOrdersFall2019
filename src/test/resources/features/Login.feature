@login
Feature: Login
    Scenario: As user, I want to be able to login with username and password

  Given user is on the login page
  When user logs in
  Then user should verify that title is a Dashboard
