package faang.school.godbless.Multitrading2.MattersOfTheHeart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        UserList userList = new UserList();

        User user1 = new User("Andrey", true);
        User user2 = new User("Alex", true);
        User user3 = new User("Petr", true);
        User user4 = new User("Sergey", true);

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService service = Executors.newFixedThreadPool(4);

        service.execute(() -> {
            chatManager.startChat(user1);
            Chat chat = null;
            chat = chatManager.waitForChat(user1);
            System.out.println(user1.getName() + " chat with " + chat.getOtherUser(user1).getName());
        });

        service.execute(() -> {
            Chat chat = chatManager.waitForChat(user2);
        });

        service.execute(() -> {
            Chat chat = chatManager.waitForChat(user3);
        });

        service.execute(() -> {
            chatManager.startChat(user4);
            Chat chat = chatManager.waitForChat(user4);
            System.out.println(user4.getName() + " chat with " + chat.getOtherUser(user4).getName());
        });
    }
}

