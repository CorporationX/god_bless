package Synchronization_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        User user1 = new User("Sasha", "m");
        User user3 = new User("Pasha", "m");
        User user5 = new User("Gosha", "m");
        User user7 = new User("Grisha", "m");
        User user2 = new User("Masha", "f");
        User user4 = new User("Dasha", "f");
        User user6 = new User("Ksysha", "f");
        User user8 = new User("Polina", "f");
        UserList.addUser(user1);
        UserList.addUser(user2);
        UserList.addUser(user3);
        UserList.addUser(user4);
        UserList.addUser(user5);
        UserList.addUser(user6);
        UserList.addUser(user7);
        UserList.addUser(user8);

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            executor.submit(() -> UserList.getOnlineUsers().get(finalI).setUpReadyToContact(true));
            executor.submit(() -> ChatManager.endChat(UserList.getOnlineUsers().get(finalI)));
        }

        executor.shutdown();
    }
}
