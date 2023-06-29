package faang.school.godbless.thirdSprint.Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int THREAD_CNT = 5;
    private static final int MAIL_CNT = 1000;
    private static final int BATCH_SIZE = MAIL_CNT / THREAD_CNT;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= THREAD_CNT; i++) {
            int startIndex = (i - 1) * BATCH_SIZE + 1;
            int endIndex = i * BATCH_SIZE;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Все письма были отправлены!");
    }
}
