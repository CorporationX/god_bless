package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int threadsCount = 13;
        int messagesCount = 1000;
        int batchSize = messagesCount / threadsCount;
        Thread[] threads = new Thread[threadsCount];

        System.out.println("Начало отправки");
        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}
