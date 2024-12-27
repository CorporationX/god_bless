package school.faang.task_48741;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadCount = 5;
        int batchSize = totalMessages / threadCount;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все письма отправлены!");
    }

}
