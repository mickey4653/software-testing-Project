# Assignment 1: Unit Testing

The _**primary purpose**_ of this assignment is to provide hands-on experience with Unit Testing. In this assignment, you will be asked to **write JUnit tests for two Java classes provided.** You will _use the techniques and good practices_ learned during the lecture to complete this assignment. 

The _**secondary purpose**_ of this assignment is to **familiarize you with Java Programming Language and your IDE**. We will be using these tools in future assignments as well. 

The two Java classes `DataSet` and `DataPoint` are provided to you in an Eclipse project. The classes are placed in the Java package `edu.umd.enpm.614.assignment1` 

## Tasks

1. **Task 1 (10 points)** : For each Java class, implement the `equals()` and `hashCode()` methods using the techniques described during the lecture. Your implementation of the `equals()` and `hashCode()` methods will be tested against our tests for correctness. (Hint: use the `compareTo()` method to make your task easier) 

1. **Task 2 (25 points)**: Write your tests in the provided test classes and perform the following testing tasks: 

    * Verify the constructors 
    * Write tests for `getters()`/`setters()` as you see fit 
    * Verify ALL other methods 

        >You are required to use JUnit conventions and good practices. Good programming style is also considered. 

1. **Task 3 (15 points)**: If you completed Task 2 correctly then this should be free points! We will run your JUnit tests against versions of the DataSet and DataPoint classes with seeded bugs; you earn points by catching these seeded bugs. The goal here is to encourage you to be thorough and creative with Unit Testing. 
