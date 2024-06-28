package faang.school.godbless.async_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREADS_NUM = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUM);

        MasterCardService masterCardService = new MasterCardService();
        Stripe stripe = new Stripe(masterCardService);

        stripe.doAll(executorService);

        executorService.shutdown();
    }
}
