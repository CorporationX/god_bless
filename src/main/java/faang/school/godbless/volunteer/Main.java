package faang.school.godbless.volunteer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    private static final int MAX_THREADS = 2;
    private static final int NUMBER_DONATIONS = 10000;
    private static final int SUM_DONATION = 100;

    private static final long AWAIT_THREAD = 20000L;

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);
        IntStream.range(0, NUMBER_DONATIONS)
                .forEach(i ->
                        executorService.execute(() ->
                                organization.addDonation(new Donation(i, SUM_DONATION))));

        executorService.shutdown();
        executorService.awaitTermination(AWAIT_THREAD, TimeUnit.SECONDS);
        organization.printBalance();

    }
}
