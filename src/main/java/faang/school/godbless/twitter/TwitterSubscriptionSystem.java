package faang.school.godbless.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
        System.out.println("У вас новый подписчик -" + Thread.currentThread().getName());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            addFollower(twitterAccount);
        });
    }

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("Kergshi", 0);
        var future = new CompletableFuture[]{
                twitterSubscriptionSystem.followAccount(twitterAccount),
                twitterSubscriptionSystem.followAccount(twitterAccount),
                twitterSubscriptionSystem.followAccount(twitterAccount),
                twitterSubscriptionSystem.followAccount(twitterAccount)
        };
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future);
        allOf.thenRun(() -> System.out.println("Общее количество подписчиков - "
                + twitterAccount.getFollowers() + "-" + Thread.currentThread().getName()));
//        try {
//            allOf.get(30, TimeUnit.SECONDS);
//        } catch (InterruptedException | ExecutionException | TimeoutException e) {
//            throw new RuntimeException(e);
//        } работает и так и так,но решил все же join оставить. get же тогда надо, когда нужно возвращаемое значение получить,
//        которого в данном случае нет. Или не в этом дело. В общем, я так и не понял
        allOf.join();
    }
}
