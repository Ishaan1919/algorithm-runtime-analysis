public class IterativeRecursiveFibonacci {
    public static void main(String[] args) {
        int n = 40; // Adjust for testing

        // Recursive Fibonacci (O(2^N))
        long start = System.currentTimeMillis();
        int recursiveResult = recursiveFibonacci(n);
        long end = System.currentTimeMillis();
        System.out.println("Recursive Fibonacci(" + n + ") = " + recursiveResult + " | Time: " + (end - start) + "ms");

        // Iterative Fibonacci (O(N))
        start = System.currentTimeMillis();
        int iterativeResult = iterativeFibonacci(n);
        end = System.currentTimeMillis();
        System.out.println("Iterative Fibonacci(" + n + ") = " + iterativeResult + " | Time: " + (end - start) + "ms");


//        Recursive Fibonacci(40) = 102334155 | Time: 441ms
//        Iterative Fibonacci(40) = 102334155 | Time: 0ms
    }

    // Recursive Fibonacci (O(2^N))
    public static int recursiveFibonacci(int n) {
        if (n <= 1) return n;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int iterativeFibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
