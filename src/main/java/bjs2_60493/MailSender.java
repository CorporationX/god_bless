package bjs2_60493;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
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
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ожидание завершения потока завершилось ошибкой: " + e.getMessage());
            }
        }

        System.out.println("Все письма отправлены");
    }
}
