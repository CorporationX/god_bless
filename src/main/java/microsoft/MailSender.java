package microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalEmails = 1000;
        int threadsCount = 5;
        int batchSize = totalEmails / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex), "Поток-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены.");
    }
}
