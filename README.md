# Java Code Challenge

## Context
This project implements a single producer multiple consumer scenario, in which you are tasked to solve various 
synchronization issues.

* Consumer.java: Logic needed for consuming the messages
* Message.java: Defines the necessary entities
* Producer.java: Logic for producing messages
* ProducerConsumerService: Service orchestration and main thread
* UseCase.java: Use case implementation
* UseCaseInterface.java: Use case interface

## Objectives
1) Solve the following error `java.lang.Exception: Messages Order:83 out of order
   at org.walmart.UseCase.process(UseCase.java:10)
   at org.walmart.Consumer.run(Consumer.java:28)
   at java.base/java.lang.Thread.run(Thread.java:1589)
   `
2) Ensure the main thread can be terminated successfully. The producer emits an "exit" message that the consumers react 
to by terminating their execution, currently the main thread hangs. Refactor as much as you need to solve this.
3) Implement a test that can validate that each consumer is processing in an ordered fashion, consider any necessary 
refactor.
4) If you note anything unusual or out of the ordinary in the code, please do mention.