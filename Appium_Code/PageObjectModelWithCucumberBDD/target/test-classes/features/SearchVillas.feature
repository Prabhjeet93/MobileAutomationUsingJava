
Feature: Goibibo Search Villas Feature
  I want to search for a villa in Goibibo app


  Scenario Outline: Searching Villas
    Given I navigate to Villas section
    When I search for a property in area "<area>"
    Then I select the checkin and checkout dates
    And I click on view stays
    And I scroll till "<apartment>"
    
    Examples:
     | area     | apartment              |
     | Maldives | Village Life Maldives  |
     | Dubai    | Baity Hotel Apartments |
     
   
