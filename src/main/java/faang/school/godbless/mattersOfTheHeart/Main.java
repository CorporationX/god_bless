package faang.school.godbless.mattersOfTheHeart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("1", true);
        User user2 = new User("2", true);
        User user3 = new User("3", true);
        User user4 = new User("4", true);

        ChatManager manager = new ChatManager();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        AtomicReference<Chat> chat1 = new AtomicReference<>();
        AtomicReference<Chat> chat2 = new AtomicReference<>();
        AtomicReference<Chat> chat3 = new AtomicReference<>();

        //сначала пускаем 2 пользователей в поиск
        executorService.execute(() -> chat1.set(manager.startChat(user1)));
        executorService.execute(() -> chat2.set(manager.startChat(user2)));

        //новы пользователь захотел початитться, но нет собеседников
        executorService.execute(() -> chat3.set(manager.startChat(user3)));

        //1, 2 пользователи наобщались, удаляем чат
        while (true) {//ветка, которая инициализирует chat1 до этого момента может не выполниться
            if (chat1.get() != null) {
                executorService.execute(() -> manager.endChat(chat1.get()));
                break;
            }
        }

        //появился еще один любитель интриг
        executorService.execute(() -> manager.startChat(user4));



        stopExecutor(executorService);
        //ожидаемый результат:
        //2 чата между пользователями 2,3 ; 1,4
    }

    private static void stopExecutor(ExecutorService service) {
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
