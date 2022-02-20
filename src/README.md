# Parking Lot System

Build a module for a parking garage system that assigns incoming cars a space to park. Assume there is a sensor at the gates to detect a car’s arrival and departure as well as a sensor at each space that detects when that space becomes occupied by a car as well as when it leaves. Cars are identified by their license plate number. Your task is to build the logic necessary to assign a parking space to an incoming car based on the current availability in the garage.

Here are the business requirements:
1. There is a very large, but finite number of spaces in the parking garage.
1. Parking spaces have a weight assigned that reflects their desirability (ex. closer to an elevator is good). Higher weight is better.
1. When a car enters the garage, it must be presented with a space to park in. The space should be the most desirable yet available spot. Calculating this spot should be done efficiently.
1. Drivers are unpredictable. You will receive a notification when they park in or leave a space and when they exit the garage. They may choose not to park in the assigned spot.

As a member of the team, you are responsible for implementing the SpaceAssigner class below. You have the following requirements:
1. Implement the SpaceAssigner class. Implement any additional classes only if required. Code should be of production quality - clearly written, runnable, and documented.
1. You are free to use any of the provided interfaces, though you may not modify them in any way. You also may not assume any implementation details of an interface beyond what has been documented.
1. The space returned by assignSpace() should be the space with the highest value of getDesirability() among the list of available spaces.
1. If no spaces are available, a null value should be returned from assignSpace().
1. This application will be run on a device with limited memory and processing resources.
1. You are free to use any tools such as IDEs to compile and test your code.
1. You may use any functions or classes from the JDK, or any 3rd party library. However, please provide rationale for any 3rd party library used. 
1. You may use a unit testing framework.
1. Assumptions other than those made above should be stated clearly at the top of your solution.
1. Write test cases that prove your solution and call your functions to demonstrate that it works.
1. Provide an analysis of the runtime complexity in big O notation for all the public APIs in SpaceAssigner. The analysis should include the average and worst-case complexity along with a brief explanation of your reasoning.