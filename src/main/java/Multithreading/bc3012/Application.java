package Multithreading.bc3012;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        User user4 = new User("User4");
        User user5 = new User("User5");
        User user6 = new User("User6");
        User user7 = new User("User7");
        UserList onlineUsers = new UserList(new ArrayList<>(List.of(
                user1, user2, user3, user4, user5, user6, user7)));
        ChatManager chatManager = new ChatManager(onlineUsers);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        while (true) {
            executor.execute(() -> chatManager.emulateChatting(user1));
            executor.execute(() -> chatManager.emulateChatting(user2));
            executor.execute(() -> chatManager.emulateChatting(user3));
            executor.execute(() -> chatManager.emulateChatting(user4));
            executor.execute(() -> chatManager.emulateChatting(user5));
            executor.execute(() -> chatManager.emulateChatting(user6));
            executor.execute(() -> chatManager.emulateChatting(user7));
        }
    }
}
