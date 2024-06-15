package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    private static final int QUANTITY_THREAD = 5;
    private static int quantityAllEmail = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(QUANTITY_THREAD);
        for (int i = 1; i <= QUANTITY_THREAD; i++) {
            List<String> partListForPool = new ArrayList<>();
            for (int j = 0; j < quantityAllEmail / QUANTITY_THREAD; j++) {
                partListForPool.add("message email: " + (i * (j + 1)));
            }
            executor.submit(new SenderRunnable(partListForPool));
        }
        executor.shutdown();
    }
}
