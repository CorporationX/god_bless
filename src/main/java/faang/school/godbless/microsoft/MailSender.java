package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int THREADS_AMOUNT = 5;
    private static final int MESSAGE_BATCHES = 200;

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            int startIndex = i * MESSAGE_BATCHES;
            int endIndex = startIndex + MESSAGE_BATCHES;

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

        System.out.println("Готово!");
    }
}
