package school.faang.bjs2_82992;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final double MIN_DONATION = 100;
    private static final double MAX_DONATION = 10_000;
    private static final int DONATION_COUNT = 1000;

    public static void main(String[] args) {
        Organization animalCharityFund = new Organization("Благотворительный фонд помощи животным");

        List<CompletableFuture<Void>> futures = new ArrayList<>(DONATION_COUNT);
        for (int i = 0; i < DONATION_COUNT; i++) {
            futures.add(CompletableFuture.runAsync(() -> {
                double money = Math.round(RANDOM.nextDouble(MIN_DONATION, MAX_DONATION) * 100) / 100.0;
                animalCharityFund.addDonation(new Donation(money));
            }));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Итоговый баланс организации '{}' равен {} денег",
                 animalCharityFund.getName(), String.format("%,.2f", animalCharityFund.getFinance()));

    }
}
