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

  @positive @TC-FR12-004 @Zaki
  # Penguji: Zaki
  Scenario: [Template] Skenario Progress Overview oleh Zaki
    # TODO: Zaki - Silakan isi skenario pengujian fungsional di sini
    # Contoh:
    # When User melihat grafik progres belajar
    # Then User dapat melihat statistik keaktifan kelas
