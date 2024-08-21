package faang.school.godbless.BJS2_23681;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MailSender {
    private static final Logger LOGGER = Logger.getLogger(MailSender.class.getName());
    private static final int AWAIT_TERMINATION_SECONDS = 60;
    private static final int THREAD_LIMIT = 5;
    private static final int TOTAL_MAIL_MESSAGES = 1000;
    private static final int MAIL_LIMIT_BY_THREAD = TOTAL_MAIL_MESSAGES / THREAD_LIMIT;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LIMIT);

        for (int i = 0; i < THREAD_LIMIT; i++) {
            int startIndex = i * MAIL_LIMIT_BY_THREAD + 1;
            int endIndex = startIndex + MAIL_LIMIT_BY_THREAD - 1;

            executorService.execute(new SenderRunnable(startIndex, endIndex));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            LOGGER.info(e.getMessage());
        }

        System.out.println("Все письма успешно отправлены. Всего отправлено писем: "
                + SenderRunnable.getLoopCounter());
    }
}
