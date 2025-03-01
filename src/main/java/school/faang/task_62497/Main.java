package school.faang.task_62497;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        TwitterAccount alex = new TwitterAccount("Alex", 2);
        TwitterAccount vik = new TwitterAccount("Vik", 2);
        TwitterAccount bob = new TwitterAccount("Bob", 1);
        TwitterAccount david = new TwitterAccount("David", 1);
        TwitterAccount jack = new TwitterAccount("Jack", 1);

        // Асинхронно подписываемся на учетные записи
        CompletableFuture<Void> future1 = system.followAccount(alex);
        CompletableFuture<Void> future2 = system.followAccount(vik);
        CompletableFuture<Void> future3 = system.followAccount(bob);
        CompletableFuture<Void> future4 = system.followAccount(david);
        CompletableFuture<Void> future5 = system.followAccount(jack);

        // Ожидаем завершения всех подписок
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3, future4, future5);


    }
}