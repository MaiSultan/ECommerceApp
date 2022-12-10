@Regression

Feature: Reset password

  Scenario: User could reset his/her password successfully
  Given User goes to login page for reset password
  And clicks Forget password Anchor
  When User enters own email
  And Clicks on Reset password Button
  Then Success message holder should appear
  And Notify message to check email for further info