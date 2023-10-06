#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@purchase
Feature: Purchase products
  As a user
	I want to be able to add two or more products to the cart and proceed with the purchase
	by placing the order

  @purchase_two_items
  Scenario: I want add two products and proceed with the purchase
    Given I have the home page opened
    And I add to products to the cart
    And I go to the Cart page
    When I click on Place Order
    And fill the form
    Then there is a confirmation message