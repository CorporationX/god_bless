package faang.school.godbless.multithreading.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) {
        List<Thread> senderThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            var thread = new Thread(new SenderRunnable(startIndex, endIndex));
            senderThreads.add(thread);
            thread.start();
        }
        senderThreads.forEach(
                thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        System.out.printf("Sending is complete. From %s", Thread.currentThread().getName());
    }
}
