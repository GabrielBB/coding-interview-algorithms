# B.Hacking
My solutions to Booking.com interview questions for Developer position

Notes:

### Consider you have unsorted list of numbers 1...10^9. What is the best data structure to find min / max element?
A heap. In java is represented by the java.util.PriorityQueue<T> class.

### What is the time complexity of the following code:

for (i=0; i < N; i++) {
  for (j=0; j < i; j++) {
  }
}

Answer: 0(N log N)