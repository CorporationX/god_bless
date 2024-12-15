package school.faang.sprint_3.task_48305;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMails = 1000;
        int totalThreads = 5;
        int batchSize = totalMails / totalThreads;

        Thread[] threads = new Thread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {
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
