package school.faang.stream4.becometwittercelebrity;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount account) {
        synchronized (account) {
            int followers = account.getFollowers();
            account.setFollowers(++followers);
        }
    }

    public void followAccount(TwitterAccount account) {
        //Используйте CompletableFuture для асинхронного запуска задач внутри метода followAccount.

    }

    //Запустите несколько задач подписки на одну учетную запись, ожидайте завершения всех задач
    //с помощью CompletableFuture.allOf() и выведите количество подписчиков учетной записи.
}
