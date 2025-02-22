package school.faang.naughtwoBJS260577;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    private static final int ALL_LETTERS = 1000;
    private static final int ALL_THREADS = 5;

    public static void main(String[] args) {
        int letterGroup = ALL_LETTERS / ALL_THREADS;

        ExecutorService executor = Executors.newFixedThreadPool(ALL_THREADS);

        for (int i = 0; i < ALL_THREADS; i++) {
            int startIndex = i * letterGroup + 1;
            int endIndex = startIndex + letterGroup;
            executor.submit(new SenderRunnable(startIndex, endIndex));
        }

        executor.shutdown();
        System.out.println("All letters have been sent!");
    }
}
