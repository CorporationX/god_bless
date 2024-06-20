package faang.school.godbless.BJS212002;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            messages.add("Message " + (i + 1));
        }

        int messagesPerThread = 200;
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * messagesPerThread;
            int endIndex = startIndex + messagesPerThread - 1;
            SenderRunnable task = new SenderRunnable(messages, startIndex, endIndex);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("All messages sent successfully");
    }
}
