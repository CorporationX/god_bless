package bjs2_35730;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        int currThread = 0;
        int totalMessages = 1000;
        int messagesPerThread = 200;

        for (int i = 1; i <= totalMessages; i++) {
            if (i % messagesPerThread == 0) {
                int endIndex = i;
                int startIndex = i - 199;

                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                Thread thread = new Thread(senderRunnable);
                threads.add(thread);
                threads.get(currThread).start();
                currThread++;
            }
        }

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
        }

        System.out.println("All mails were successfully delivered!");
    }
}
