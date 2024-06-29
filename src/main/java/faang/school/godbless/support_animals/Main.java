package faang.school.godbless.support_animals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_NUM = 10;
    private static final long TIME_LIMIT = 5000L;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        IntStream.range(0, THREAD_NUM).forEach(
                i -> executorService.execute(
                        () -> organization.addDonation(new Donation(i, i * 1000))
                )
        );

        executorService.shutdown();

        try {
            boolean isTerminated = executorService.awaitTermination(TIME_LIMIT, TimeUnit.MILLISECONDS);

            if (isTerminated) {
                System.out.println("Total amount of money: " + organization.getTotalAmount().get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
