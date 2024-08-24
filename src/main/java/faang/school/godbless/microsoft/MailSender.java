package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static final int THREAD_COUNT = 5;

    public static final int MESSAGES_PART = 200;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT;) {
            int startIndex = i * MESSAGES_PART;
            int endIndex = startIndex + MESSAGES_PART;

            threads.add(new Thread(() -> new SenderRunnable(startIndex, endIndex)));
            i++;
        }

        threads.forEach((thread) -> {
            System.out.println(thread.getName() + " - запустился");
            thread.start();
        });

        for (Thread thread : threads) {
            System.out.println(thread.getName() + " - щас джоинится");
            thread.join();
            System.out.println(thread.getName() + " - завершил работу");
        }
        System.out.println("Сообщения отправлены");
    }
}
