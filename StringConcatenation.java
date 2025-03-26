public class StringConcatenation {
    public static void main(String[] args) {
        int iterations = 1000; // Number of concatenations

        // String (Immutable - O(N^2))
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a"; // Creates a new object each time
        }
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start) + "ns");

        // StringBuilder (Mutable - O(N))
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) + "ns");

        // StringBuffer (Thread-safe, Mutable - O(N))
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) + "ns");


//        String Time: 2554300ns
//        StringBuilder Time: 133300ns
//        StringBuffer Time: 264700ns
    }
}
