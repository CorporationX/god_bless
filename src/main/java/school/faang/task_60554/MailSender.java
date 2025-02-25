package school.faang.task_60554;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int numberOfThreads = 5;
        int batchSize = totalEmails / numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Поток был прерван: " + e.getMessage());
            }
        }
    }
}
