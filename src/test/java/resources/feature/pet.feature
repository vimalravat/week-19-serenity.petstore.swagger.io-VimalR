Feature: Testing different request on the PETSTORE application

  Scenario: Check if the PETSTORE application can be accessed by users
    When User sends a GET request to list endpoint
    Then User must get back a valid status code 200

  Scenario Outline: Create a new PETSTORE & verify if the PET is added
    When I create a new PET by providing the information firstName "<firstName>" lastName "<lastName>" email "<email>" programme "<programme>" courses "<courses>"
    Then I verify that the PET with "<email>" is created
    Examples:
      | firstName | lastName | email            | programme        | courses |
      | Prime     | prime1   | prime1@gmail.com | Computer Science | JAVA    |
      | Prime2    | prime3   | prime2@gmail.com | Api Testing      | Python  |





