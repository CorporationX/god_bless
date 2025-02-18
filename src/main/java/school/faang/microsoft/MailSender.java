package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;
    private static final Logger LOGGER = Logger.getLogger(MailSender.class.getName());

    public static void main(String[] args) {
        int groupSize = TOTAL_MESSAGES / THREADS_COUNT;
        LOGGER.setLevel(Level.INFO);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * groupSize;
            int endIndex = (i + 1) * groupSize;
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
            threads.get(i).start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        LOGGER.info("All messages were sent");
    }
}
