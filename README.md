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

### Select all pairs of adjacent chars that match, and delete them. For instance, the string aab could be shortened to b in one operation.

static void superReducedString(String s)
{
    Stack<Character> stack = new Stack<>();
    for (int i = s.length() - 1; i >= 0; i--)
    {
        char c = s[i];
        if (stack.size() > 0 && stack.peek() == c)
        {
            stack.pop();
        }
        else
        {
            stack.push(c);
        }
    }

    // Print elements of Stack here
}

### Advice: Brute force it, first! I mean, real brute force

### Modulo (%) can be used in rotation algorithms

If you have a range between 1 and 9. And you wanna rotate the number "5" 22 times to the right you will have to iterate the range 22 times. But if you use the formula 22 % 9  that will give 4. You just have to move "5" four times to the right.