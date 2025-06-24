package school.faang.bjs281386;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int TOTAL_EMAILS = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int EMAIL_PER_THREAD = TOTAL_EMAILS / THREAD_COUNT;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * EMAIL_PER_THREAD;
            int endIndex = startIndex + EMAIL_PER_THREAD;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            new Thread(senderRunnable).start();
        }

        List<Thread> threads = new ArrayList<Thread>();

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
