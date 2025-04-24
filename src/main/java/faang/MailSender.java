package faang;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int MULTIPLIER = 200;
    public static final int THREADS_COUNT = 5;

    public static void main(final String[] args) throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            final int startIndex = getStartIndex(i);
            final int endIndex = getEndIndex(i);

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static int getEndIndex(int i) {
        return (i + 1) * MULTIPLIER - 1;
    }

    private static int getStartIndex(int i) {
        return i * MULTIPLIER;
    }
}

