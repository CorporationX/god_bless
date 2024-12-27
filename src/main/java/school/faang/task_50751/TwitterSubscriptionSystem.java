package school.faang.task_50751;

import java.util.List;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account, List<User> users) {

    }
}
//2️⃣ Создайте класс TwitterSubscriptionSystem, который будет управлять подписками на учетные записи Twitter.
//3️⃣ Реализуйте метод addFollower(TwitterAccount account), который увеличивает количество подписчиков учетной записи.
// Этот метод должен быть синхронизирован, чтобы корректно работать при одновременном доступе из нескольких потоков.
//4️⃣ Создайте метод followAccount(TwitterAccount account), который асинхронно добавляет подписчика к учетной записи, вызывая addFollower.
//5️⃣ Используйте CompletableFuture для асинхронного запуска задач внутри метода followAccount.
//6️⃣ Запустите несколько задач подписки на одну учетную запись, ожидайте завершения всех задач с помощью CompletableFuture.allOf()
// и выведите количество подписчиков учетной записи.