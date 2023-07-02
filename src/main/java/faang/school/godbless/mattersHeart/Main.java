package faang.school.godbless.mattersHeart;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Peter");
        User user2 = new User("Maria");
        User user3 = new User("Kristian");

        ChatManager chatManager = new ChatManager();

        chatManager.addUser(user1);
        chatManager.addUser(user2);
        chatManager.addUser(user3);

        startChatForUsers(chatManager.getOnlineUsers(), chatManager);
    }

    public static void startChatForUsers(List<User> users, ChatManager chatManager) {
        for (User user : users) {
            Thread thread = new Thread(() -> {
                chatManager.startChat(user);
                chatManager.waitForChat(user);
            });
            thread.start();
        }
    }
}
