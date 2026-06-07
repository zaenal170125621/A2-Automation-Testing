@functional
Feature: Functional Testing - JTK Learn (Progress Overview - FR12)
  As a user of JTK Learn application
  I want to verify core functionalities work correctly
  So that the application meets quality standards

  Background:
    Given User has opened the browser
    And User has navigated to the JTK Learn login page
    And User is logged in with email "Pengajar5@example.com" and password "Pengajar5"

  @positive @TC-FR12-001 @Dzaka
  # Penguji: Dzaka
  Scenario: [Template] Skenario Progress Overview oleh Dzaka
    # TODO: Dzaka - Silakan isi skenario pengujian fungsional di sini
    # Contoh:
    # When User mengakses halaman pemantauan progres
    # Then User dapat melihat list progres kelas

  @positive @TC-FR12-003 @Zaenal
  # Penguji: Zaenal
  Scenario: Verify course aggregate data displays correctly on Pemantauan page
    When User clicks on the Pemantauan menu link
    Then User should see the Pemantauan page
    And User should see course "CyberSecurity" with 11 students, 2 materials, and 3 quizzes
    When User clicks on the Progres button for course "CyberSecurity"
    Then User should be navigated to the course progress overview page

  @negative @TC-FR12-008 @Zaki
  # Penguji: Zaki 
  Scenario: Display progress overview when course has no registered students
    When User clicks on the Pemantauan menu link
    Then User should see the Pemantauan page
    And User should see course "Kursus Kosong A2" with 0 students, 1 materials, and 1 quizzes
    When User clicks on the Progres button for course "Kursus Kosong A2"
    Then User should be navigated to the course progress overview page
    And User should see the message "Belum ada pelajar yang mengikuti kursus."
