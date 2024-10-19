package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        int currThread = 0;
        int totalMail = 1000;
        int threadMaxMail = 200;

        for (int i = 0; i < totalMail; i++) {
            final int maxMail = threadMaxMail-1;
            if (i % threadMaxMail == 0) {
                int endIndex = i - maxMail;
                SenderRunnable senderRunnable = new SenderRunnable(i, endIndex);
                Thread thread = new Thread(senderRunnable);
                threads.add(thread);
                threads.get(currThread).start();
                currThread++;
            }
        }
        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("finished");
    }

}
