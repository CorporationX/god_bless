package school.faang.microsoft.outlook;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int LETTERS_COUNT = 1000;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < LETTERS_COUNT; i += BATCH_SIZE) {
            Thread thread = new Thread(new SenderRunnable(i, i + BATCH_SIZE));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Отправка писем завершена успешно!");
    }
}
