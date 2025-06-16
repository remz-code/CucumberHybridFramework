@all
Feature: Register a new User

Background:
Given User Navigate to Register Page

@register @mandatoryfields @smoke @regression
Scenario: Register new User with Mandatory fields
When User Enters below details to fields
|firstname   |Remya|
|lastname    |Appukuttan|
|telephone   |1234567890|
|password     |12345|
And Select Privacy Policy Field
And Click on continue button
Then Account should successfully created

@register @willallfields @smoke @regression
Scenario: Register new User with All fields
When User Enters below details to fields
|firstname   |Remya|
|lastname    |Appukuttan|
|telephone   |1234567890|
|password     |12345|
And Select Yes for Newsletter
And Select Privacy Policy Field
And Click on continue button
Then Account should successfully created

@register @withoutprovidinganyfields  @regression @ignore
Scenario: Register without providing any fields
When     User not providing any details to the fields
And      Click on continue button
Then   Warning messages should be displayed for all mandatory fields

@register @duplicateemail  @regression
Scenario: Register with duplicate Email Address
When User Enters the  below details to fields
|firstname   |Remya|
|lastname    |Appukuttan|
|email       |remyz@gmail.com|
|telephone   |1234567890|
|password     |1234|
And Select Yes for Newsletter
And Select Privacy Policy Field
And Click on continue button
Then Warning messgae indicating that duplicate email should be displayed 