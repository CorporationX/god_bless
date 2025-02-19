package bjs2_60493;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        final int CHUNK_COUNT = 5;
        final int CHUNK_SIZE = 200;

        Thread[] threads = new Thread[CHUNK_COUNT];

        for (int i = 0; i < 5; i++) {
            int startIndex = CHUNK_SIZE * i;
            int endIndex = CHUNK_SIZE * (i + 1);

            SenderRunnable runner = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(runner);
            thread.start();

            threads[i] = thread;
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
