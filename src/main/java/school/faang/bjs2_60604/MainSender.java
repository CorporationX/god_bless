package school.faang.bjs2_60604;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainSender {
    private static final int THREADS_COUNT = 5;
    private static final int MESSAGE = 1000;

    public static void main(String[] args)  throws Exception {
        Thread[] threads = new Thread[THREADS_COUNT];
        int batchSize = MESSAGE / THREADS_COUNT;
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Главный поток был прерван", e);
                throw new RuntimeException("Главный поток был прерван во время ожидания завершения работы потоков", e);
            }
            System.out.println("Все письма отправлены!");
        }
    }
}
