package school.faang.task_51690;

public class TwitterSubscriptionSimulation {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        // Создание учетной записи Twitter
        TwitterAccount account = new TwitterAccount("@exampleUser");

        // Запуск подписок
        subscriptionSystem.processSubscriptions(account, 10);
    }
}

