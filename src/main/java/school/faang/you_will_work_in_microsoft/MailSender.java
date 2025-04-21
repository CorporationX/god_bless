package school.faang.you_will_work_in_microsoft;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {

        int batchSize = TOTAL_MESSAGES / THREAD_COUNT;
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            System.out.printf("Поток № %d из запущен из основного потока: %s", i, Thread.currentThread().getName());
        }
        for (Thread thread : threads) {
            thread.join();
            System.out.printf("Работа текущего потока успешно завершена%n");
        }
    }
}
