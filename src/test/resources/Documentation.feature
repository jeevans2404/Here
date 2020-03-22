Feature: document link Verification in Doc Page

  Scenario: Verify the Documentation link in Here website page
    Given launch url for Here website "https://developer.here.com/"
    Then Navigate to Documentation page
    And verify active Documentation link in Documentaion page
    Then close the browser