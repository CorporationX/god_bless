package school.faang.task_48735;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    public static void main(String[] args) {
        int start;
        int end;
        int threadsCount = 5;
        int tasksCount = 1000;
        int taskPerThreadCount = tasksCount / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            start = i * taskPerThreadCount;
            end = (i + 1) * taskPerThreadCount;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
        }

        log.info("Программа завершилась!");
    }
}
