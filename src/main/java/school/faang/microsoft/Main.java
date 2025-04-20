package school.faang.microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    private static final int TOTAL_NUMBER_LETTERS = 1000;
    private static final int TOTAL_COUNT_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        int countLettersForOneThread = TOTAL_NUMBER_LETTERS / TOTAL_COUNT_THREAD;
        Thread[] threads = new Thread[5];

        for (int i = 0; i < TOTAL_COUNT_THREAD; i++) {
            int startIndex = i * countLettersForOneThread;
            int endIndex = (i + 1) * countLettersForOneThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
