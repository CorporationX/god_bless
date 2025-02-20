package school.faang.youworkinmicrosoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {

        int averageNumberOfMessages = TOTAL_MESSAGES / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * averageNumberOfMessages;
            int end = (i + 1) * averageNumberOfMessages;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидание потока {}", e.getMessage());
            }
        }
        System.out.println("Все потоки отработали!");
    }
}