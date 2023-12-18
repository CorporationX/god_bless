package faang.school.godbless.parallelism.microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new SenderRunnable((i * 200) + 1, (i + 1) * 200));
        }
        executorService.shutdown();
    }

}
