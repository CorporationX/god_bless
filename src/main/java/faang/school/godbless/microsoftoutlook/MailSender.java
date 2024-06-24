package faang.school.godbless.microsoftoutlook;


import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int POOL_SIZE = 5;
    private static final int MAX_VALUE = 200;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < POOL_SIZE; i++) {
            int start = i * MAX_VALUE;
            int end = start + MAX_VALUE;
            Thread thread = new Thread(new SenderRunnable(start, end));
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("All emails are send");

    }
}
