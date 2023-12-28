package faang.school.godbless.tinder;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        for (int i = 0; i < 8; i++) {
            userList.addUser(new User("User_" + (i + 1), true, true));
        }
        ChatManager chatManager = new ChatManager(userList);

        for (User user : userList.getOnlineUsers()) {
            new Thread(() -> {
                try {
                    chatManager.startChat(user);
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                chatManager.endChat(user);
            }).start();
        }
    }
}
