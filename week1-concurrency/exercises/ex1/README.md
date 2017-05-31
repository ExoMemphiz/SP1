# Exercise 1: Handling threads

## Task 1
Open this repository in your favourite editor and open the ``Threads`` and 
read the exercises inside.

## Task 2
Open this repository in your favourite editor and open the ``Even`` and 
read the exercises inside.

## Task 3 - 5
The three tasks are available from this repository
[https://github.com/Lars-m/threadExDay1.git](https://github.com/Lars-m/threadExDay1.git).
Clone or fork the repository and read the description below.

### Task 3 (Blocking the GUI-thread)
Execute the main method in ex3.BallDemo.java. There is a problem here. Can you find it?

Solve the problem by rewriting the Ball class to extend ``Thread`,
so that 1) the balls can be started / stopped asynchronously and 2) the program 
can be terminated by pressing the cross.

### Exercise 4 (race condition)
Use the code in the package ex4 as start code for this exercise. This program simulates a 
large football stadium with many turnstiles that each updates a shared counter, for each 
spectator that passes a turnstile.

Initially, the code is set up to simulate 40 turnstiles, each (running in a separate thread) 
simulates that 1000 spectators pases.

Execute the code and observe the reslult of the shared counter.

If the result is not as expected, solve the problem:
1) Using the traditional synchronization
2) Using a AtomicInteger
3) Using a java.util.concurrent.locks.ReentrantLock

### Exercise 5 (race condition)
Execute the main code in either ``ex5.BankApp.java`` or ``ex5.BankAppExecutor.java``

The program includes a method executeTransactions () which executes a series of transactions 
on a shared account object and prints true / false depending on the expected outcome.

* Identify places in the code where it "goes wrong".
* What should the closing balance be?

**Experiment**: Increase the number of calls of executeTransactions () or the number of 
threads and observe the effect.

Observe that there are two versions of the main() method, one that creates threads in a 
traditional way, and one using an ``ExecutorService`` (the recommended way).

Solve the problem in the Bank program:
1) Using the traditional synchronization
2) Using a java.util.concurrent.locks.ReentrantLock

## Task 6
Open this repository in your favourite editor and open the ``Printer`` and 
read the exercises inside.
