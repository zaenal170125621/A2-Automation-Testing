@login
Feature: Login Functionality
  As a user of JTK Learn application
  I want to be able to login with valid credentials
  So that I can access the learning platform

  Background:
    Given User has opened the browser
    And User has navigated to the JTK Learn login page

  @positive @TC-0.0.1 @Dzaka
  # Penguji: Dzaka
  Scenario: [Template] Check login is successful with valid credentials as role "Pengajar"
    # TODO: Dzaka - Silakan isi langkah-langkah pengujian di sini
    # Contoh:
    # When User enters email "Pengajar5@example.com" in the email field
    # And User enters password "Pengajar5" in the password field
    # And User clicks on the login button
    # Then User should be navigated to the dashboard page

  @negative @TC-0.0.2 @TC-FR12-002 @Zaenal
  # Penguji: Zaenal
  Scenario: Check login is unsuccessful with invalid credentials - unregistered email
    When User enters email "indra@example.com" in the email field
    And User enters password "admin123" in the password field
    And User clicks on the login button
    Then User should see an unsuccessful login notification message
