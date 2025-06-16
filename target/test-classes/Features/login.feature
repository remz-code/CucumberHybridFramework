@all
Feature: Registered User Login 

Background:
Given  User navigate to Login page
@login  @validcredential  @regression
Scenario Outline: Login With valid credential
When Enter Valid email address <email>
And  Enter Valid password <password>
And  Click on Login  button
Then Sucesfully logged the user
Examples:
|email                  |password|
|remyz@gmail.com         | 1234 |
|amotooricap@gmail.com  |12345 |
|amotooricap3@gmail.com  |12345 |

@login  @Invalidcredential @smoke @regression
Scenario: Login With Invalid credential
When  Enter InValid email address 
And   Enter InValid password "123456"
And  Click on Login  button
Then Proper Warning message should displayed

@login  @InvalidEmailAddressandValidPassword  @regression
Scenario: Login With Invalid Email Address and Valid Password
When  Enter InValid email address 
And   Enter Valid password "1234"
And  Click on Login  button
Then Proper Warning message should displayed

@login  @validEmailAddressandInvalidPassword  @regression @dev
Scenario: Login With valid Email Address and Invalid Password
When  Enter Valid email address "remyz@gmail.com"
And   Enter InValid password "123478"
And  Click on Login  button
Then Proper Warning message should displayed