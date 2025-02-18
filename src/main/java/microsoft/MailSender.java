package microsoft;

import java.util.logging.Logger;

public class MailSender {
    private static final Logger logger = Logger.getLogger(MailSender.class.getName());

    public static void main(String[] args) {
        int totalEmails = 1000;
        int totalThreads = 5;
        int emailsPerThread = totalEmails / totalThreads;

        Thread[] threads = new Thread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = (i + 1) * emailsPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        try {
            for (int i = 0; i < totalThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            logger.severe("Thread interrupted: " + e.getMessage());
            logger.severe("Stack trace: ");
            for (StackTraceElement element : e.getStackTrace()) {
                logger.severe(element.toString());
            }
        }
        logger.info("All emails has been successfully sent!");
    }
}