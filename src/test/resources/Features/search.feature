@all
Feature: Search Functionality

Background:
Given User open the application

Scenario: Search with valid productname
When User enter the Valid Product in the Search field "HP"
And User Clicks on the Search button
Then Valid product details is listed after searching


Scenario: Search with Invalid productname
When User enter the InValid Product in the Search field "Boat"
And User Clicks on the Search button
Then Warning message should displayed about product display


Scenario: Search without any  productname
When User dont enter any product in the search field
And User Clicks on the Search button
Then Warning message should displayed about product display

