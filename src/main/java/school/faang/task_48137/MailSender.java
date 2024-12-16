package school.faang.task_48137;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(200 * (i - 1), i * 200 - 1);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка выполнения потока");
            }
        }

        System.out.println("Done");
    }
}
