package school.faang.task_48347;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {
    private static final int BATCH_SIZE = 200;
    private static final int TOTAL_SIZE = 1000;
    private static final Logger LOGGER = Logger.getLogger(MailSender.class.getName());

    public static void main(String[] args) {
        int threadsCount = TOTAL_SIZE / BATCH_SIZE;
        Thread[] mailSenderThreads = new Thread[threadsCount];

        for (var i = 0; i < threadsCount; i++) {
            mailSenderThreads[i] = new Thread(new SenderRunnable(i * BATCH_SIZE, (i + 1) * BATCH_SIZE));
            mailSenderThreads[i].start();
        }

        for (var mailSenderThread : mailSenderThreads) {
            try {
                mailSenderThread.join();
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARNING, "Thread was interrupted", e);
            }
        }

        System.out.println("Все письма отправлены");
    }
}
