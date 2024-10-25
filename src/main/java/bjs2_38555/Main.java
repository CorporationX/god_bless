package bjs2_38555;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution(20);

        long start = System.currentTimeMillis();
        double pi = solution.calculatePi(1_200_000_000);
        long end = System.currentTimeMillis();
        System.out.println("Multithreading result: " + pi + "duration: " + (end - start) + " ms");

        long start2 = System.currentTimeMillis();
        double pi2 = solution.calculatePiContinuously(1_200_000_000);
        long end2 = System.currentTimeMillis();
        System.out.println("Continuously result: " + pi2 + "duration: " + (end2 - start2) + " ms");
    }
}
