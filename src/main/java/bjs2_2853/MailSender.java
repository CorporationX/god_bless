package bjs2_2853;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            SenderRunnable runnable = new SenderRunnable(startIndex, startIndex + 199);
            Thread thread = new Thread(runnable);
            thread.start();
            threads.add(thread);
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все письма отправлены");
    }
}
