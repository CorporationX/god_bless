package school.faang.s_4_1_become_twitter_celebrity;

import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет! Вы в твиттере!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Юзер1, введите ваше имя: ");
        String name1 = scanner.nextLine();
        TwitterAccount account1 = new TwitterAccount(name1);
        System.out.print("Юзер2, введите ваше имя: ");
        String name2 = scanner.nextLine();
        TwitterAccount account2 = new TwitterAccount(name2);

        TwitterAccount account3 = new TwitterAccount("Sony");
        TwitterAccount account4 = new TwitterAccount("Rex");
        TwitterAccount account5 = new TwitterAccount("Billy");

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        CompletableFuture<Void> future1 = subscriptionSystem.followAccount(account1, account1);
        CompletableFuture<Void> future2 = subscriptionSystem.followAccount(account1, account2);
        CompletableFuture.allOf(future1, future2).join();
        System.out.println(account1.getFollowers());
        subscriptionSystem.shutdown();
    }
}
