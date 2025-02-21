package school.faang.bjs2_60604;

public class MainSender {
    private static final int THREAS_COUNT = 5;
    private static final int MESSAGE = 1000;

    public static void main(String[] args)  throws InterruptedException {
        Thread[] threads = new Thread[THREAS_COUNT];
        int batchSize = MESSAGE / THREAS_COUNT;
        for (int i = 0; i < THREAS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Главный поток был прерван во время ожидания завершения работы потоков", e);
            }
        }
    }
}
