package school.faang.bjs2_91164_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        final int TOTAL_EMAILS = 20;
        final int THREAD_COUNT = 5;
        final int EMAIL_PER_THREAD = TOTAL_EMAILS / THREAD_COUNT;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * EMAIL_PER_THREAD;
            int endIndex = (i < THREAD_COUNT - 1) ? startIndex + EMAIL_PER_THREAD - 1 : TOTAL_EMAILS - 1;

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