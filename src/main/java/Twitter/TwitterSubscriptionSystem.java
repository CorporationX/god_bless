package Twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    //При использовании synchronized получается что метод блокируется независимо от того увеличиваем мы
    //количество подписчиков у одного и того же аккаунта или у разных
    //т.к. локом является объект TwitterSubscriptionSystem а не TwitterAccount с которым мы работаем
    private synchronized void addFollower(TwitterAccount twitterAccount){
        //увеличивает количество подписчиков учетной записи.
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount twitterAccount){
        //асинхронный метод
        //добавляет подписчика используя addFollower
    return CompletableFuture.supplyAsync(() -> {
       addFollower(twitterAccount);
       return twitterAccount;
    });
    }
}
