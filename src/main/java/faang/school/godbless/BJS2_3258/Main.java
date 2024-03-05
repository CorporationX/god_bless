package faang.school.godbless.BJS2_3258;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Привет. Я видимо немного ушел от изначального задания, так как запутался в условии и сделал очередь ожидания для
// поиска собеседника. Надеюсь это попадет под допуск некоторой вариативности из условияЖ : "Эта задача предоставляет
// вам огромное поле для импровизации".
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Database database = new Database();
        ChatManager chatManager = new ChatManager(database);
        for (int i = 1; i <= 23; i++) {
            int idx = i;
            executorService.execute(() -> {
                User user = chatManager.registerUser("user" + idx);
                chatManager.requestChat(user);
                List<Chat> userChats = chatManager.waitChat(user);
                System.out.println(Thread.currentThread().getName() + ": " + user + ": " + userChats);
            });
        }
        // Один из пользователей все еще ожидает, т.к изначально количество нечетное, поэтому добавляем еще одного
        // пользователя, чтобы найти пару для оставшегося изначально.
        Thread.sleep(3000);
        executorService.execute(() -> {
            User user = chatManager.registerUser("additionalUser");
            chatManager.requestChat(user);
            List<Chat> userChats = chatManager.waitChat(user);
            System.out.println(Thread.currentThread().getName() + ": " + user + ": " + userChats);
        });
        // Удалим чат у пользователя для демонстрации работы метода
        Thread.sleep(1000);
        executorService.execute(() -> {
            User user = chatManager.loginUser("additionalUser");
            List<Chat> chats = chatManager.waitChat(user);
            Chat chat = chats.get(0);
            chatManager.leaveChat(user, chat);
            User otherUser = chat.getUsers().get(0);
            System.out.println(Thread.currentThread().getName() + ": " + otherUser + ": " + chatManager.waitChat(otherUser));
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
