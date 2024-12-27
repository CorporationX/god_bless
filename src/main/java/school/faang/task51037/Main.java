package school.faang.task51037;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    private static final int MAX_AMOUNT = 500;
    private static final int MAX_COUNT_ACCOUNTS = 10;

    public static void main(String[] args) {

        Bank bank = new Bank();

        CompletableFuture.allOf(IntStream.range(0, MAX_COUNT_ACCOUNTS)
                        .mapToObj(Account::new)
                        .peek(bank::addAccount)
                        .toList().stream()
                        .map(account -> CompletableFuture.supplyAsync(() -> {
                            ThreadLocalRandom random = ThreadLocalRandom.current();

                            account.deposit(random.nextDouble(MAX_AMOUNT));
                            account.withdraw(random.nextDouble(MAX_AMOUNT));

                            bank.transfer(account.getId(), random.nextInt(MAX_COUNT_ACCOUNTS),
                                    random.nextDouble(MAX_AMOUNT));
                            return bank.getTotalBalance();
                        }))
                        .toArray(CompletableFuture[]::new))
                .join();
    }
}
