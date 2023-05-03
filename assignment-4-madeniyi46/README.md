[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/TxI1zqJq)
# Assignment 4: Web Testing with Selenium 

1. ## Setup Project (5 points)
    Task 1 (5 points): First you will have to setup this project to run JUnit tests for this assignment. All tests should be in 
    `src/test/java` in the package `edu.umd.enpm614.assignment4`. Google Chrome is required to run your tests, you can 
    install the latest stable version of [Google Chrome from here](https://cloud.google.com/chrome-enterprise/browser/download/).
    
    To run tests with Selenium on Chrome for this assignment, you must first download the version of `chromedriver`
    compatible with your operating system and the version of Chrome from the [chromedriver website](https://chromedriver.storage.googleapis.com/index.html).
    Then, unzip the contents of the download and copy/move the file to `src/test/resources`. 
    Lastly, you must ensure in `Assignment4ApplicationTests.class` at line 27, the parameter matches the name of the file you saved to the resources folder.
    You can test that your tests are set up correctly, if you are able to successfully run tests and the browser pops open for a few seconds.
    
    > Do NOT make changes to `src/main/java` or `src/main/resources`. 
    
3. ## Write passing tests for Web Application (20 points)
    Task 2 (20 points): Test the Web App fully according to the 
    [Toy Web Application Specifications](#toy-web-application-specification). You must be 
    familiar with an application before you can write good tests for it, therefore, spend some time playing around 
    with this web application before you start writing tests. 
    > Note: All behaviors of Web App are considered correct, and your test cases for the original Web App 
      should always pass.
4. ## Write strict tests for the web application (25 points)
    Task 3 (25 points): Same as the JUnit Assignment, we will run your JUnit tests against versions of the Web App with
     seeded bugs; you earn points by catching these seeded bugs. The goal here is to encourage you to be thorough and 
     creative with Web Testing.
    
### Submission
When submitting make sure your project builds in GitHub otherwise your submission will not be graded.

# Toy Web Application Specification
> The web application is feature complete and current behavior is the desired behavior. Please do not change any
> functionality of the application. This application has two features: Calculator (at `/math`) and Form (at `/form`)

## Calculator
* All user interactions are done through the URL query parameters
* 3 parameters are passed in through the URL

    | Field | Description |
    | ----- | ----------- |
    | `param1` | must be an integer number |
    | `param2` | must be an integer number |
    | `operator` | must be “plus” or “minus” |
    
* Results (math operation results or error messages) will be shown
* Don’t worry about integer value overflow!

## Form
* User interactions are done through HTML form
* 3 fields and a submit button in the form
    
    | Field             | Description |
    | -----             | ----------- |
    | Email Address     | email must have "umd.edu" domain |
    | Color             | any of the 3 selections |
    | I agree		    | must be checked |
    | Submit            | submits form data |
* Review page reviews (displays) all of the form data submitted
* If validations fail, errors are displayed on the page

 
