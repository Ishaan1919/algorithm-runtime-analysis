public class SearchingLargeDataset {
    public static void main(String[] args) {
        int size = 1000000;
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = i+1;
        }
        int target = size;

        long startTime = System.nanoTime();
        linearSearch(arr,target); // T.C O(N);
        long endTime = System.nanoTime();

        System.out.println("Time take by linear search: " + (endTime-startTime));

        startTime = System.nanoTime();
        binarySearch(arr,target); // T.C O(log N)
        endTime = System.nanoTime();
        System.out.println("Time take by binary search: " + (endTime-startTime));

//        Array size = 1000
//        Time take by linear search: 32701
//        Time take by binary search: 6400

//        Array size = 10000
//        Time take by linear search: 145300
//        Time take by binary search: 7100

//        Array size = 100000
//        Time take by linear search: 5430500
//        Time take by binary search: 11100

    }

    public static boolean linearSearch(int[] arr, int target){
        for(int i:arr){
            if(i==target) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target){
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]>target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return true;
    }
}