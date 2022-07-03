Feature: Booking search hotels test

  Scenario: Find Hotel Whit Rating
    Given User on the search page
    When User search "Penzion Horajda"
    Then "Penzion Horajda" on the search page
    Then Rating is "8.9" on this hotel