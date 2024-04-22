package faang.school.godbless.become_celebrity_in_twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.getFollowers().addAndGet(1);
    }

    // В подсказках сказано использовать synchronized, однако как я понял это не best practice,
    // использовать входные параметры для синхронизации. Можно было бы сделать Object lock внутри TwitterAccount,
    // но решение с AtomicInteger должно быть лучше (если ничего не путаю, то и работает оно быстрее).
    // Верное ли данное решение или тут все таки необходим synchronized?
    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount), executorService);
    }
}