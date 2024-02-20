package faang.school.godbless.r_edzie.parallelism.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int THREAD_AMOUNT = 5;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = startIndex + BATCH_SIZE;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threadList.add(thread);
        }

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Done");
    }
}
