@logout
Feature: Logout Functionality
  As a logged in user of JTK Learn application
  I want to be able to logout from the system
  So that my session is securely ended

  Background:
    Given User has opened the browser
    And User has navigated to the JTK Learn login page
    And User is logged in with email "Pengajar5@example.com" and password "Pengajar5"

  @positive @TC-2.0.1 @Zaki
  # Penguji: Zaki
  Scenario: [Template] Check logout is successful
    # TODO: Zaki - Silakan isi langkah-langkah pengujian di sini
    # Contoh:
    # When User clicks on the profile or menu button
    # And User clicks on the logout button
    # Then User should be redirected to the login page
