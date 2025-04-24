package school.faang.sprint3multythreading.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int THREAD_COUNT = 5;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * BATCH_SIZE;
            int end = (i + 1) * BATCH_SIZE;
            threads[i] = new Thread(new SenderRunnable(start, end), "SenderThread-" + i);
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Прерывание потока {}. Смотри ошибки: {}", threads[i].getName(), e.getMessage());
            }
        }

        System.out.println("Все письма успешно отправлены!!!");
    }
}