package celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int USER_COUNT = 10;

    public static void main(String[] args) {
        TwitterSubscriptionSystem followService = new TwitterSubscriptionSystem();
        var users = initUsers();
        var futureList = users.stream()
                .flatMap(u -> IntStream.range(0, 100)
                        .mapToObj(i -> followService.followAccount(u)))
                .toList();
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        users.forEach(u -> log.info(String.format("%s has %d followers", u.getUsername(), u.getFollowers())));
    }

    private static List<TwitterAccount> initUsers() {
        return IntStream.rangeClosed(1, USER_COUNT)
                .mapToObj(i -> new TwitterAccount("User_" + i))
                .toList();
    }
}
