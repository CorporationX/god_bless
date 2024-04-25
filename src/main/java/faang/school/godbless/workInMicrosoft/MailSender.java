package faang.school.godbless.workInMicrosoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i ++) {
            int startIndex = i * 200;
            int endIndex = Math.min(startIndex + 199, TOTAL_MESSAGES - 1);
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            executorService.submit(senderRunnable);
        }
        executorService.shutdown();
        System.out.println("Messages sent!");
    }
}
