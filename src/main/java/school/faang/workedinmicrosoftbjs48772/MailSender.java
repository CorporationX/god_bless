package school.faang.workedinmicrosoftbjs48772;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {
    private static final int THREADSCOUNT = 5;
    private static final int TOTALMESSAGE = 1000;
    private static final int BATCHSIZE = TOTALMESSAGE / THREADSCOUNT;
    private static final Logger logger = Logger.getLogger(MailSender.class.getName());

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADSCOUNT];

        for (int i = 0; i < THREADSCOUNT; i++) {
            int startIndex = i * BATCHSIZE;
            int endIndex = (i + 1) * BATCHSIZE;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (int i = 0; i < THREADSCOUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All email was send");
    }
}
