Feature: Booking

  Scenario: Book a flight

    Given I navigate to Booking
    Then I navigate to flights page
    And I select number of passengers
    And I add destination "Vienna, Austria"
    And I add depart and return date "27/03/2022" "31/03/2022"
    And I click search
    And I Select one-way flight
    And I select flight
    Then I accept cookies
    Then I enter contact details "United Kingdom"
    Then I select baggage
    Then I click on Continue and finished test
