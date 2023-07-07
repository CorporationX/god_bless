package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task11;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        User user1 = new User("Икакий", true, true);
        User user2 = new User("Везерис", true, false);
        User user3 = new User("Рикард", true, false);
        User user4 = new User("Игорь", true, false);
        User user5 = new User("Симпсон", true, true);

        UserList userList = new UserList();
        userList.addOnlineUser(user1);
        userList.addOnlineUser(user2);
        userList.addOnlineUser(user3);
        userList.addOnlineUser(user4);
        userList.addOnlineUser(user5);

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> chatManager.startChat(user1));
        executor.execute(() -> chatManager.startChat(user3));
        executor.execute(() -> chatManager.startChat(user5));
        executor.execute(() -> chatManager.endChat(chatManager.getChatList().get(0)));

        executor.shutdown();

        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("done");
    }
}
