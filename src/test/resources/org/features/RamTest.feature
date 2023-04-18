Feature: An example

  Scenario: Login into "sauce demo" and select the highest price item and add the cart.
    Given user navigate to Login page "https://www.saucedemo.com/"
    When user enter username "standard_user" and password "secret_sauce"
    And click login button
    Then user can find the title "Products"
    And select the dropdown to price high to Low
    And add the selected highest price item to the cart.
    And click the cart
    Then user can be seeing the checkout

