package school.faang.sprint3.task_60648;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MailSender {
    private static final List<String> EMAILS = new ArrayList<>();
    private static final int COUNT_EMAILS = 200;
    private static final int START_INDEX = 0;
    private static final int ZERO = 0;
    private static final int EMAIL_COUNT = 1000;
    private static final int THREAD_SLEEP = 3000;

    static {
        String[] strings = {"one", "two", "three"};
        Random random = new Random();

        for (int i = ZERO; i < EMAIL_COUNT; i++) {
            EMAILS.add(strings[random.nextInt(START_INDEX, strings.length)]);
        }
    }

    public static void main(String[] args) {
        int threadNumber = 1;
        int size = EMAILS.size();
        int end;

        for (int i = 0; i < size; i += COUNT_EMAILS) {
            end = Math.min(i + COUNT_EMAILS, size);
            Thread thread = new Thread(new SenderRunnable(threadNumber++, EMAILS.subList(i, end)));
            thread.start();
        }

        sleep();
        System.out.printf("Обработано %d писем из %d\n", SenderRunnable.emailNumber - 1, EMAILS.size());
    }

    private static void sleep() {
        try {
            Thread.sleep(THREAD_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
