package school.faang.task_48691;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int threadCount = 5;
        int mails = 1000;
        int batchSize = mails / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize - 1;

            if (i == threadCount - 1) {
                end = mails - 1;
            }
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}