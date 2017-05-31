# Exercise 2: Threads, Observables and Producer/Consumer

To do this assignment, clone this repository to your own pc and follow the list of tasks below.

Feedback is always welcome! :-) Good luck

## Tasks
1. ``UrlRetriever``
2. ``UrlRetrieverSynchronisation``
3. ``ObservableFibonacciCalculator``
4. ``ResponsiveFibonacciGui``
5. See below

## Task 5
Execute the code in the package deadlock.

The program contains a class ``ResourceContainer`` that contains the following two lists:
* ``List<String> words = new ArrayList();``
* ``List<Integer> numbers = new ArrayList();``

Multiple concurrent threads needs to add data to these lists without interference from other
threads. The pattern for use is as follows:
A list is available from a thread by calling ``getResourceWords()`` which returns the first
list and then sets a lock (``Lock``) so subsequent calls from other threads will be blocked.
After use of the list the lock is released by calling ``ReleaseResourceWords()``

1. Does the program behave as expected?
2. If not try to detect the emergence of a deadlock, see below.

All JVMs have a single implementation of the interface ``ThreadMXBean`` containing relevant thread
monitoring methods. Use the ``DeadLockDetector`` and start it in a thread. Observe if a deadlock
is detected.

3. If this revealed a deadlock: Identify the problem(s) and solve it/them.

## More non-mandatory assignments
Many of these assignments were inspired by Lars' implementation which also contains some new
interesting concurrency problems. Find them here:
[https://github.com/Lars-m/threadExDay2](https://github.com/Lars-m/threadExDay2)