package faang.school.godbless.tinder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);
        List<User> users = userList.getUsers();

        userList.addUser(new User("Ivan", 31, true, true));
        userList.addUser(new User("Olesya", 28, false, true));
        userList.addUser(new User("Igor", 22, false, true));
        userList.addUser(new User("Anna", 19, true, true));
        userList.addUser(new User("Mihail", 20, true, true));
        userList.addUser(new User("Anastasia", 18, true, true));

        for (User user : users) {
            new Thread(() -> {
                try {
                    Chat chat = chatManager.startChat(user);
                    chatManager.waitForChat(chat);
                    chatManager.endChat(chat);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
