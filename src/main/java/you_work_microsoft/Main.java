package you_work_microsoft;

public class Main {
    public static void main(String[] args) {
        int totalMessage = 1000;
        int threadCount = 5;
        int batchSize = totalMessage / threadCount;
        Thread[] threads = new Thread[threadCount];


        for (int i = 0; i < threadCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}