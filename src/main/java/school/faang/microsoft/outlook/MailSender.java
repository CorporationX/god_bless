package school.faang.microsoft.outlook;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int LETTERS_COUNT = 1000;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {
        int threadCount = LETTERS_COUNT / BATCH_SIZE;
        List<Thread> threads = new ArrayList<>(threadCount);
        for (int i = 0; i < LETTERS_COUNT; i += BATCH_SIZE) {
            Thread thread = new Thread(new SenderRunnable(i, i + BATCH_SIZE - 1));
            thread.start();
            threads.add(thread);
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("Отправка писем завершена успешно!");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
