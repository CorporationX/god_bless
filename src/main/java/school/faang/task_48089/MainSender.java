package school.faang.task_48089;

public class MainSender {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        int batchSize = 200;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.printf("%nВсе письма отправлены");
    }
}
