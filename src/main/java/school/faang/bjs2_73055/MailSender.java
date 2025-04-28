package school.faang.bjs2_73055;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_COUNT = 50;
    private static final int TOTAL_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        int batch = TOTAL_COUNT / TOTAL_THREAD;
        Thread[] threadPool = new Thread[TOTAL_THREAD];
        for (int i = 0; i < TOTAL_THREAD; i++) {
            int startIndex = i * batch;
            int endIndex = (i + 1) * batch;
            threadPool[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threadPool[i].start();
        }

        for (Thread thread : threadPool) {
            thread.join();
        }

        log.info("Complete.");
    }
}