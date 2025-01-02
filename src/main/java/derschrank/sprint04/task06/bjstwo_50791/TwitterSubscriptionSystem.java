package derschrank.sprint04.task06.bjstwo_50791;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int DEFAULT_DELAY = 1000;

    public CompletableFuture<Void> addFollower(TwitterAccount account, TwitterAccount toAccount) {
        if (account == toAccount) {
            return CompletableFuture.runAsync(() ->
                    System.out.println(" . " + account.name() + " can't subscribe to yourself"));
        }

        String begin = " + " + account.name() + " following " + toAccount.name();
        String end = " - " + account.name() + " followed " + toAccount.name();
        System.out.println(begin);

        toSleep(DEFAULT_DELAY);

        return CompletableFuture.runAsync(
                () -> account.followAccount(toAccount)
                )
                .thenRun(
                        () -> toAccount.addFollower(account)
                )
                .thenRun(
                        () -> System.out.println(end)
                );
    }

    private void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("TwitterSubscriptionSystem was interrupted: " + e);
        }
    }
}
