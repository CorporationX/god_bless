package Twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
// создаем аккаунты
        List<TwitterAccount> accounts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            accounts.add(new TwitterAccount("Name" + i));
        }
//подписываемся на рандомные аккаунты и добавляем фучеры в allOf
        List<CompletableFuture<TwitterAccount>> futerList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            TwitterAccount currentAccount = accounts.get((int) (Math.random() * accounts.size()));
            futerList.add(twitterSubscriptionSystem.followAccount(currentAccount));
        }
        CompletableFuture<Void> allFuters = CompletableFuture.allOf(futerList.toArray(new CompletableFuture[0]));
        allFuters.get();

        //смотрим количество подписок и проверяем что не потеряли подписок
        int totalSubscribes = 0;
        for (TwitterAccount account : accounts) {
            System.out.println(account.getUsername() + " " + account.getFollowers());
            totalSubscribes += account.getFollowers();
        }
        System.out.println(totalSubscribes);
    }
}
