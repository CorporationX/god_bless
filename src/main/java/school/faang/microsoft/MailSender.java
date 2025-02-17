package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        try {
            addThread(new Thread(new SenderRunnable(0, 200)));
            addThread(new Thread(new SenderRunnable(200, 400)));
            addThread(new Thread(new SenderRunnable(400, 600)));
            addThread(new Thread(new SenderRunnable(600, 800)));
            addThread(new Thread(new SenderRunnable(800, 1000)));
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        }

        for (Thread thread : THREADS) {
            thread.start();
        }

        try {
            for (Thread thread : THREADS) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }

        log.info("Выполнено успешно!");
    }

    private static void addThread(Thread thread) {
        THREADS.add(thread);
    }
}