package microsoft;

import java.util.logging.Logger;

public class MailSender {
    private static final Logger logger = Logger.getLogger(MailSender.class.getName());
    private static final int TOTAL_EMAILS = 1000;
    private static final int TOTAL_THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        int emailsPerThread = TOTAL_EMAILS / TOTAL_THREADS;
        int remainderEmails = TOTAL_EMAILS % TOTAL_THREADS;

        Thread[] threads = new Thread[TOTAL_THREADS];

        for (int threadIndex = 0; threadIndex < TOTAL_THREADS; threadIndex++) {
            int startIndex = threadIndex * emailsPerThread;
            int endIndex = startIndex + emailsPerThread;

            if (remainderEmails > 0) {
                startIndex += Math.min(threadIndex, remainderEmails);
                if (threadIndex < remainderEmails) {
                    endIndex++;
                }
            }

            threads[threadIndex] = new Thread(new SenderRunnable(startIndex, endIndex), "Sender-" + threadIndex);
            logger.info("Starting thread " + threadIndex + " for emails " + (startIndex + 1) + " to " + endIndex);
            threads[threadIndex].start();
        }

        for (int threadIndex = 0; threadIndex < TOTAL_THREADS; threadIndex++) {
            try {
                threads[threadIndex].join();
            } catch (InterruptedException e) {
                logger.severe("Thread interrupted: " + e.getMessage());
                for (StackTraceElement element : e.getStackTrace()) {
                    logger.severe(element.toString());
                }
                Thread.currentThread().interrupt();
            }
        }
        logger.info("All emails have been successfully sent!");
    }
}