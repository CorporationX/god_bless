package school.faang.sprint_4.task_50850;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TwitterAccount account = new TwitterAccount("Joe");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture<Void> task1 = system.followAccount(account);
        CompletableFuture<Void> task2 = system.followAccount(account);
        CompletableFuture<Void> task3 = system.followAccount(account);

        CompletableFuture.allOf(task1, task2, task3).join();

        System.out.println("Количество подписчиков: " + account.getFollowers());
    }
}
