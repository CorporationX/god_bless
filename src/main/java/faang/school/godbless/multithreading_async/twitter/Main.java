package faang.school.godbless.multithreading_async.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Bukevsky", 1000);
        System.out.println(twitterAccount);
        List<CompletableFuture<Void>> listFuture = processFollows(twitterAccount,1999);
        CompletableFuture.allOf(listFuture.toArray(CompletableFuture[]::new)).join();
        System.out.println(twitterAccount);
    }

    private static List<CompletableFuture<Void>> processFollows(TwitterAccount twitterAccount, int count){
        List<CompletableFuture<Void>> listFuture = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            listFuture.add(TwitterSubscriptionSystem.followAccount(twitterAccount));
        }
        return listFuture;
    }

}
