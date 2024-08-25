package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static final int THREAD_COUNT = 5;

    public static final int MESSAGES_PART = 200;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * MESSAGES_PART;
            int endIndex = startIndex + MESSAGES_PART - 1;

            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }

        threads.forEach((thread) -> {
            System.out.println(thread.getName() + " - запустился");
            thread.start();
        });

        for (Thread thread : threads) {
            thread.join();
            System.out.println(thread.getName() + " - завершил работу");
        }
        System.out.println("Сообщения отправлены");
    }
}
