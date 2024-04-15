package faang.school.godbless.you_work_for_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new SenderRunnable(1, 200)));
        threads.add(new Thread(new SenderRunnable(201, 400)));
        threads.add(new Thread(new SenderRunnable(401, 600)));
        threads.add(new Thread(new SenderRunnable(601, 800)));
        threads.add(new Thread(new SenderRunnable(801, 1000)));

        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        System.out.println("All mails were sent");
    }
}