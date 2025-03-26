import java.util.*;

public class SearchUsingDS {
    public static void main(String[] args) {
        int size = 1_000_000; // Adjust size for different tests
        int searchValue = size / 2; // Value to search for

        // Populate structures
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        // Array Search (O(N))
        long start = System.currentTimeMillis();
        boolean foundInArray = linearSearch(array, searchValue);
        long end = System.currentTimeMillis();
        System.out.println("Array Search Time: " + (end - start) + "ms | Found: " + foundInArray);

        // HashSet Search (O(1) on average)
        start = System.currentTimeMillis();
        boolean foundInHashSet = hashSet.contains(searchValue);
        end = System.currentTimeMillis();
        System.out.println("HashSet Search Time: " + (end - start) + "ms | Found: " + foundInHashSet);

        // TreeSet Search (O(log N))
        start = System.currentTimeMillis();
        boolean foundInTreeSet = treeSet.contains(searchValue);
        end = System.currentTimeMillis();
        System.out.println("TreeSet Search Time: " + (end - start) + "ms | Found: " + foundInTreeSet);

//        Array Search Time: 4ms | Found: true
//        HashSet Search Time: 0ms | Found: true
//        TreeSet Search Time: 0ms | Found: true
    }

    // Linear Search (O(N))
    public static boolean linearSearch(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
