package school.faang.task_60526;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    private static final int QUANTITY_EMAIL = 1000;
    private static final int QUANTITY_EMAIL_IN_ONE_THREAD = 200;

    public static void main(String[] args) {

        Thread[] threads = new Thread[QUANTITY_EMAIL / QUANTITY_EMAIL_IN_ONE_THREAD];

        for (int i = 0; i < QUANTITY_EMAIL / QUANTITY_EMAIL_IN_ONE_THREAD; i++) {
            int startIndex = i * QUANTITY_EMAIL_IN_ONE_THREAD + 1;
            int endIndex = startIndex + QUANTITY_EMAIL_IN_ONE_THREAD - 1;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            log.info("Поток писем {} начался отправляться", i + 1);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Все письма успешно отправлены!");
    }
}
