package school.faang.bjs2_89553;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int emailCount = 1000;

        for (int i = 1; i <= emailCount; i++) {
            SenderRunnable task = new SenderRunnable(i, 200);
            executor.execute(task);
        }
        executor.shutdown();
    }
}
