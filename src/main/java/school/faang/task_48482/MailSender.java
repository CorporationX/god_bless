package school.faang.task_48482;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;
        int start;
        int end;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            start = i * batchSize;
            end = (i + 1) * batchSize;
            SenderRunnable sender = new SenderRunnable(start, end);
            threads[i] = new Thread(sender);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Произошло прерывание потока");
            }
        }

        System.out.println("Все письма отправлены!");
    }
}

