package school.faang.sprint3.BJS2_60648;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MailSender {
    private static final List<String> EMAILS = new ArrayList<>();
    private static final int COUNT_EMAILS = 200;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(COUNT_EMAILS);

    static {
        String[] strings = {"one", "two", "three"};
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            EMAILS.add(strings[random.nextInt(0, 3)]);
        }
    }

    public static void main(String[] args) {
        int threadNumber = 1;
        int size = EMAILS.size();
        int end;

        for (int i = 0; i < size; i += COUNT_EMAILS) {
            end = Math.min(i + COUNT_EMAILS, size);
            EXECUTOR.submit(new SenderRunnable(threadNumber++, EMAILS.subList(i, end)));
        }

        EXECUTOR.shutdown();
        while (!EXECUTOR.isTerminated()) {}
        // почему-то не всегда 1000 из 1000, бывает 997-1000
        System.out.printf("Обработано %d писем из %d\n", SenderRunnable.emailNumber - 1, EMAILS.size());
    }
}
