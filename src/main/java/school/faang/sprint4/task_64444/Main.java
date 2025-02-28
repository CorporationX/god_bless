package school.faang.sprint4.task_64444;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final String TRANSFER_FORM = "{} transfer from {} to {} amount {}";
    private static final List<CompletableFuture<Void>> FUTURES_TRANSFERS = new ArrayList<>();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
    private static final Random RANDOM = new Random();
    private static final Bank BANK = new Bank();
    private static final int ACCOUNT_COUNT = 2;
    private static final int TRANSFER_COUNT = 100;
    private static final double MAX_AMOUNT_TRANSFER = 100D;

    public static void main(String[] args) {
        IntStream.range(0, ACCOUNT_COUNT)
                .mapToObj(num -> new Account())
                .forEach(BANK::addAccount);

        IntStream.range(0, TRANSFER_COUNT).forEach(non ->
                    FUTURES_TRANSFERS.add(CompletableFuture.runAsync(Main::randomTransfer, EXECUTOR)));

        CompletableFuture.allOf(FUTURES_TRANSFERS.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    FUTURES_TRANSFERS.clear();
                    EXECUTOR.shutdownNow();
                    log.info("total balance is {}", BANK.getTotalBalance());
                });
    }

    private static void randomTransfer() {
        int fromId = getRandomId();
        int toId = getRandomId(fromId);
        double amount = RANDOM.nextDouble(1, MAX_AMOUNT_TRANSFER);
        log.debug(TRANSFER_FORM, "Try made", fromId, toId, amount);
        String res = BANK.transfer(fromId, toId, amount) ? "Made" : "Rejected";

        log.info(TRANSFER_FORM, res, fromId, toId, amount);
    }

    private static int getRandomId() {
        return getRandomId(-1);
    }

    private static int getRandomId(int ignore) {
        int id;
        do {
            id = RANDOM.nextInt(0, ACCOUNT_COUNT);
        } while (id == ignore);

        return id;
    }
}
