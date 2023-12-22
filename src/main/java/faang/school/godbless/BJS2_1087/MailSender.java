package faang.school.godbless.BJS2_1087;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int messagesPerThread = 200;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < totalMessages; i += messagesPerThread) {
            int startIndex = i + 1;
            int endIndex = startIndex + messagesPerThread;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            threads.add(thread);
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все сообщения отправлены.");
    }
}