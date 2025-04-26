package school.faang.tinder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ChatManager chatManager = new ChatManager();

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");

        chatManager.registerUser(user1);
        chatManager.registerUser(user2);
        chatManager.registerUser(user3);
        chatManager.registerUser(user4);

        new Thread(() -> {
            try {
                user1.setLookingForChat(true);
                log.info("Пользователь {} ждет приглашения", user1.getName());
                Chat chat = chatManager.waitForChat(user1);
                chat.sendMessage(user1, "Принял приглашение");
                chatManager.endChat(chat);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Chat chat = chatManager.startChat(user2);
                chat.sendMessage(user2, "Позвал в чат " + chat.getOtherUser(user2).getName());
                chatManager.endChat(chat);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                Chat chat = chatManager.startChat(user3);
                chat.sendMessage(user3, "Позвал в чат");
                chatManager.endChat(chat);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Поток прерван");
            }
        }).start();

        new Thread(() -> {
            try {
                Chat chat = chatManager.startChat(user4);
                chat.sendMessage(user4, "Позвал в чат");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Поток прерван");
            }
        }).start();
    }
}
