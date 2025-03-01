package school.faang.task_62497;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            system.followAccount(new TwitterAccount("Alex", 2));
            system.followAccount(new TwitterAccount("Alex", 2));
            system.followAccount(new TwitterAccount("Bob", 1));
            system.followAccount(new TwitterAccount("David", 1));
            system.followAccount(new TwitterAccount("Jack", 1));
        });

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
    }
}
