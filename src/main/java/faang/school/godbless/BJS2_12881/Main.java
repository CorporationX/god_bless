package faang.school.godbless.BJS2_12881;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserList users = new UserList();
        ChatList chats = new ChatList();
        ChatManager chatManager = new ChatManager(chats, users);

        users.addUser(new User("Паша"));
        users.addUser(new User("Коля"));
        users.addUser(new User("Оля"));
        users.addUser(new User("Маша"));
        users.addUser(new User("Валя"));

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            while (users.isWantsToChat()) {
                User user = users.getUsers().get(Rand.RAND.nextInt(users.getUsers().size()));
                try {
                    chatManager.startChat(user);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(e.getMessage() + " поток был прерван");
                }
            }
        });

        executorService.shutdown();
        if (executorService.awaitTermination(3, TimeUnit.MINUTES)) {
            System.out.println("Закончились желающие чатиться");
        }
    }
}
