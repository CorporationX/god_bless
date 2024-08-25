package faang.school.godbless.MicrosoftJob;

public class MailSender {
    public static void main(String[] args) {
        Config config = new Config();
        int totalEmails = config.get("totalEmails");
        int threadsCount = config.get("threadsCount");
        int emailsPerThread = threadsCount > 0 ? totalEmails / threadsCount : 0;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = (i == threadsCount - 1) ? totalEmails - 1 : (i + 1) * emailsPerThread - 1;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex), "Thread-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Sending was interrupted while receiving ");
                Thread.currentThread().interrupt();
                return;
            }
        }

       System.out.println("All emails have been sent successfully.");
    }
};
