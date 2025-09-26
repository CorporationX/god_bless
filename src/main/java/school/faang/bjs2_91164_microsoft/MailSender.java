package school.faang.bjs2_91164_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        final int totalEmails = 20;
        final int threadCount = 5;
        final int emailPerThread = totalEmails / threadCount;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * emailPerThread;
            int endIndex = (i < threadCount - 1) ? startIndex + emailPerThread - 1 : totalEmails - 1;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }


        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все письма отправлены");
    }
}