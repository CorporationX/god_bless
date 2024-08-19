package faang.school.godbless.sprint3.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int THREAD_AMOUNT = 5;
    private static final int MAIL_LIMIT = 200;
    private static List<Thread> threads = new ArrayList<>(THREAD_AMOUNT);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(MAIL_LIMIT * i + 1, MAIL_LIMIT * (i + 1) + 1);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Все письма отправлены!");
    }
}
