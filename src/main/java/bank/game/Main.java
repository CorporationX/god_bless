package bank.game;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    private static final int ACCOUNTS_COUNT = 10;

    public static void main(String[] args) {
        var accounts = initAccount();
    }

    private static List<Account> initAccount() {
        return IntStream.range(0, ACCOUNTS_COUNT)
                .mapToObj(i -> new Account())
                .toList();
    }
}
