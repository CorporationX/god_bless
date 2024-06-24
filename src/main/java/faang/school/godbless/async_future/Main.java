package faang.school.godbless.async_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Stripe stripe = getStripe();

        stripe.doAll(executorService);

        executorService.shutdown();
    }

    private static Stripe getStripe() {
        MasterCardService masterCardService = new MasterCardService();

        return new Stripe(masterCardService);
    }
}
