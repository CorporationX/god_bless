package school.faang;

public class Main {
    public static void main(String[] args) {
        int lettersStack = 1000;
        int threadCol = 5;
        int batchSize = lettersStack / threadCol;
        Thread[] threads = new Thread[threadCol];

        for (int i = 0; i < threadCol; i++) {
            int startIndex = (i * batchSize) + 1;
            int endIndex = ((i + 1) * batchSize) + 1;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, restoring the interrupt status.");
                break;
            }
        }

        System.out.println("All letters was sent");

    }

}