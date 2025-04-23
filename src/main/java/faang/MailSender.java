package faang;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int MULTIPLIER = 200;

    public static void main(final String[] args) throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            final int startIndex = i * MULTIPLIER;
            final int endIndex = (i + 1) * MULTIPLIER - 1;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}

