package school.faang.microsoft;

/**
 * Проект: god_bless
 * Класс MailSender
 * Автор: Vital
 */

public class MailSender {
    private final int totalMessages;
    private final int threadsCount;

    public MailSender(int totalMessages, int threadsCount) {
        this.totalMessages = totalMessages;
        this.threadsCount = threadsCount;
    }

    public void sendAllMails() throws InterruptedException {
        int batchSize = totalMessages / threadsCount;
        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end), "SenderThread-" + (i + 1));
            threads[i].start();
        }
        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все письма отправлены!");
    }
}