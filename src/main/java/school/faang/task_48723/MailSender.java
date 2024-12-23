package school.faang.task_48723;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int quantityMessages = 1000;
        int quantityThread = 5;
        int batchSize = quantityMessages / quantityThread;

        Thread[] threads = new Thread[quantityThread];
        for (int i = 0; i < quantityThread; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}
