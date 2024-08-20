package multithreading.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int messageCount = 1000;
        int threadCount = 5;
        int batchSize = messageCount / threadCount;
        int batchStart = 1;
        List<Thread> threadList = new ArrayList<>();
        while (messageCount > 0) {
            Thread thread = new Thread(new SenderRunnable(batchStart, batchStart + batchSize));
            threadList.add(thread);
            batchStart += batchSize;
            messageCount -= batchSize;
            thread.start();
        }
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("All messages sended!");
    }
}
