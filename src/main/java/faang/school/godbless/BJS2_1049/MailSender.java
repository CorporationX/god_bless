package faang.school.godbless.BJS2_1049;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = (200 * i) + 1;
            int endIndex = (200 * i) + 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток прерван" + thread.toString());
            }
        }
        System.out.println("Все письма отправлены");

    }
}
