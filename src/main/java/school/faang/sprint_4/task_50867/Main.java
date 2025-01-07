package school.faang.sprint_4.task_50867;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args){
        TwitterAccount account = new TwitterAccount("user", 15);

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        int numberOfFollowersToAdd = 5;

        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        IntStream.range(0, numberOfFollowersToAdd).forEach(i -> tasks.add(
                CompletableFuture.runAsync(() -> system.followAccount(account)))
        );

        try {
            CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Один из потоков прервал работу");
        }

        System.out.println(account);
    }
}
