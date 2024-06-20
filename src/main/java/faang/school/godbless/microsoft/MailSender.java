package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    private static final int QUANTITY_THREAD = 5;
    private static int quantityAllEmail = 1000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(QUANTITY_THREAD);
        List<String> allMail = new ArrayList<>();
        for(int i = 0; i < quantityAllEmail; i++) {
            allMail.add("some message!");
        }
        int numberLettersPerThread = quantityAllEmail / QUANTITY_THREAD;
        for (int i = 1; i <= QUANTITY_THREAD; i++) {
            int startIndex = (i - 1) * numberLettersPerThread;
            int endIndex = i * numberLettersPerThread - 1;
            List<String> partListForPool = allMail.subList(startIndex, endIndex);
            for (int j = 0; j < quantityAllEmail / QUANTITY_THREAD; j++) {
                executor.submit(new SenderRunnable(partListForPool));
            }
        }
        executor.shutdown();
    }
}
