package faang.school.godbless.BJS2_11947;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        int threadsCount = 5;
        int emailsCount = 1000;
        int threadSize = emailsCount / threadsCount;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(new SenderRunnable(i * threadSize + 1, i * threadSize + threadSize + 1));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All done");
    }
}
