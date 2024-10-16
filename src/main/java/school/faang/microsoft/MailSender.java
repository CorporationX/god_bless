package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int threadsCount = 5;
        int batchSize = totalEmails / threadsCount;
        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All letters have been sent!");
    }
}
