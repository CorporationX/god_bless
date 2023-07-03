package faang.school;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public void addFollowers(TwitterAccount account) {
        account.followersInc();
    }

    //Не использовал синхронизацию, так как это AtomicInteger переменная,
    //она, вроде, гарантирует норм работу при многопоточности. Поправлю, если неправ
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.followersInc();
        });
    }
}
