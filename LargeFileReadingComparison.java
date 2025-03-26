import java.io.*;

public class LargeFileReadingComparison {
    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; // Ensure a large file exists

        // Using FileReader (Character Stream)
        long start = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {} // Reading character by character
        }
        long end = System.currentTimeMillis();
        System.out.println("FileReader Time: " + (end - start) + "ms");

        // Using InputStreamReader (Byte Stream -> Character Stream)
        start = System.currentTimeMillis();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {} // Reading byte by byte and converting
        }
        end = System.currentTimeMillis();
        System.out.println("InputStreamReader Time: " + (end - start) + "ms");

//        FileReader Time: 48ms
//        InputStreamReader Time: 7ms
    }
}
