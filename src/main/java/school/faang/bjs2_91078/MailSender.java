package school.faang.bjs2_91078;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    private static final int MAIL_COUNT = 1000;
    private static final int MAIL_COUNT_IN_THREAD = 200;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < MAIL_COUNT; i += MAIL_COUNT_IN_THREAD) {

            Thread thread = new Thread(new SenderRunnable(i, i + MAIL_COUNT_IN_THREAD));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(t -> {
            try {
                t.join();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Задача была прервана");
            }
        });
        System.out.println("Все письма отправлены!");
    }

}
