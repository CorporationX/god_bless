package school.faang.tinder;

import school.faang.tinder.exceptions.UserAlreadyInChatException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        UserList userList = new UserList();
        User kolya = new User(1, "Коля", true, true);
        User andrey = new User(2, "Андрей", true, true);
        User kostya = new User(3, "Костя", true, true);
        User misha = new User(4, "Миша", true, true);
        User vova = new User(5, "Вова", true, true);

        userList.addUser(kolya);
        userList.addUser(andrey);
        userList.addUser(kostya);
        userList.addUser(misha);
        userList.addUser(vova);

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executor = Executors.newFixedThreadPool(userList.getSize());
        for (User user : userList.getUsers()) {
            executor.submit(() -> {
                int chatId = 0;
                try {
                    chatId = chatManager.startChat(user);
                } catch (UserAlreadyInChatException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                chatManager.endChat(chatId);
            });
        }

    }
}
