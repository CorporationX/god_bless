package faang.school.godbless.mt.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        var messages = new String[1_0];

        final int threadsCount = 5;
        final int batchSize = messages.length / threadsCount;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            var start = i * batchSize;
            var end = (i+ 1) * batchSize;
            var thread = new Thread(new SenderRunnable(start, end));
            threads.add(thread);
            thread.start();
        }

        for (var thread : threads) {
            thread.join();
        }

        System.out.println("Main end");
    }

}
