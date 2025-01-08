package derschrank.sprint04.task06.bjstwo_50791;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Random rnd = new Random();
    private static final int COUNT_OF_SIMPLE_ACCOUNTS = 3;
    private static final TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

    public static void main(String[] args) {
        List<TwitterAccount> bloggers = List.of(
            new TwitterAccount("Blogger #1"),
            new TwitterAccount("Blogger #2"),
            new TwitterAccount("Blogger #3")
        );
        List<TwitterAccount> accounts = getAccounts(COUNT_OF_SIMPLE_ACCOUNTS);

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        futures.addAll(subscribeEachAccountToFiveOtherAccounts(accounts));
        futures.addAll(subscribeEachAccountToBloggers(accounts, bloggers));

        CompletableFuture<Void> futureForWait = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );
        futureForWait.join();

        accounts.addAll(bloggers);
        printAccounts(accounts);
    }

    private static List<TwitterAccount> getAccounts(int count) {
        List<TwitterAccount> accounts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            accounts.add(new TwitterAccount(getLastName(i) + " " + getFirstName()));
        }
        return accounts;
    }

    private static String getLastName(int index) {
        String[] lastNames = new String[]{
                "Ivanov",
                "Sidorov",
                "Petrov",
                "Fedorov",
                "Smolenko",
                "Burbalenko",
                "Panchin",
                "Kazanzev",
                "Zadornov",
                "Mischustin",
                "Danilov",
                "Frolov",
        };

        return lastNames[index % lastNames.length];
    }

    private static String getFirstName() {
        String[] firstNames = new String[]{
                "Ivan",
                "Sidor",
                "Petr",
                "Fedor",
                "Smol",
                "Burb",
                "Pan",
                "Kazan",
                "Gena",
                "Mischa",
                "Danil",
                "Frol",
        };

        return firstNames[(rnd.nextInt(firstNames.length) * rnd.nextInt(firstNames.length)) % firstNames.length];
    }

    private static List<CompletableFuture<Void>> subscribeEachAccountToFiveOtherAccounts(
            List<TwitterAccount> accounts) {
        final int toCountAccounts = 5;
        int size = accounts.size();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (TwitterAccount account : accounts) {
            for (int i = 0; i < toCountAccounts; i++) {
                futures.add(
                        system.addFollower(account, accounts.get(rnd.nextInt(size)))
                );
            }
        }

        return futures;
    }

    private static List<CompletableFuture<Void>> subscribeEachAccountToBloggers(
            List<TwitterAccount> accounts, List<TwitterAccount> bloggers) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (TwitterAccount account : accounts) {
            for (TwitterAccount toAccount : bloggers) {
                futures.add(
                        system.addFollower(account, toAccount)
                );
            }
        }

        return futures;
    }

    private static void printAccounts(List<TwitterAccount> accounts) {
        for (TwitterAccount account : accounts) {
            System.out.println(account);
        }
    }

}
