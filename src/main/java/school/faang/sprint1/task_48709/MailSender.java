package school.faang.sprint1.task_48709;

public class MailSender {
    public static void main(String[] args) {
        int totalMessage = 1000;
        int threadsCount = 5;
        int batchSize = totalMessage / threadsCount;

        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Операция завершена");
    }
}
