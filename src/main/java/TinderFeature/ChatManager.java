package TinderFeature;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ChatManager {
    private final UserList userList;
    @Getter
    private final List<Chat> chats;

    public synchronized Optional<Chat> startChat(User user1) throws InterruptedException {
        while (true) {
            List<User> onlineUsers = UserList.getOnlineUsers(UserList.users);
            onlineUsers.remove(user1);
            if (!onlineUsers.isEmpty()) {
                User user2 = onlineUsers.get((int) (Math.random() * onlineUsers.size()));
                Chat chat = new Chat(user1, user2);
                chats.add(chat);
                user1.setCurrentChat(chat);
                user2.setCurrentChat(chat);
                notifyAll();
                return Optional.of(chat);
            } else {
                wait();
            }
        }
    }

    public void waitForChat(User user) throws InterruptedException {
        synchronized (this) {
            while (user.getCurrentChat() == null) {
                wait();
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (this) {
            chats.remove(chat);
            chat.getUser1().setCurrentChat(null);
            chat.getUser2().setCurrentChat(null);
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserList userList = new UserList();

        User user1 = new User("Sasha", 1, true);
        User user2 = new User("Dasha", 2, true);
        User user3 = new User("Masha", 3, false);

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);

        ChatManager chatManager = new ChatManager(userList, new ArrayList<>());

        // Test startChat
        Optional<Chat> chat1 = chatManager.startChat(user1);
        if (chat1.isPresent()) {
            System.out.println("Чат создан между " + chat1.get().getUser1().getName() + " и " + chat1.get().getUser2().getName());
        } else {
            System.out.println("Чат не найден");
        }

        // Test waitForChat
        chatManager.waitForChat(user2);
        System.out.println(user2.getName() + " присоеденился(-лась) к чату");

        // Test endChat
        chatManager.endChat(chat1.get());
        System.out.println("Вышли из чата " + chat1.get().getUser1().getName() + " и " + chat1.get().getUser2().getName());
    }
}
