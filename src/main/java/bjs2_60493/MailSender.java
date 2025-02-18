package bjs2_60493;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            int startIndex = 200 * i;
            int endIndex = 200 * (i + 1);

            SenderRunnable runner = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(runner);
            thread.start();

            threads.add(i, thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
