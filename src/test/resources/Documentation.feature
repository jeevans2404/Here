Feature: document

  Scenario: Verify the Documentation link in Here website page
    Given launch url for Here website "https://developer.here.com/"
    Then Navigate to Documentation page
    Then verify active Documentation link in Documentaion page