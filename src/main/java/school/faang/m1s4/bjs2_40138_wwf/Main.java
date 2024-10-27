package school.faang.m1s4.bjs2_40138_wwf;

import lombok.extern.slf4j.Slf4j;
import school.faang.ThreadPoolService.ThreadPoolService;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long SLEEP_TIME = 5000;
    private static final int N_DONATIONS = 50;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Organization organization = new Organization();

        for (int i = 0; i < N_DONATIONS; i++) {
            organization.addDonation(new Donation(RANDOM.nextDouble(10)));
        }

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }

        organization.getBalance();
        System.out.println(organization.getDonationsInfo());
        System.out.println(organization.getDonationsInfo().size());

        ThreadPoolService.shutdownPool(organization.getService(), 300, TimeUnit.SECONDS);
    }
}
