package faang.school.godbless.task.Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<String> messages = new ArrayList<>(1000);
        for (int i = 1; i <= 1000; i++) {
            messages.add(String.valueOf(i));
        }

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SenderRunnable(messages,i * 200, (i + 1) * 200 - 1));
            threads.add(thread);
            thread.start();
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All messages have been sent");
    }
}
