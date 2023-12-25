package faang.school.godbless.multithreading.synchronizedPractice.mattersOfTheHeart;

import java.util.HashSet;
import java.util.Set;

public class ChatManager {

    private final UserList userList;
    private final Set<Chat> chats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chats = new HashSet<>();
    }

    public synchronized void startChat(User user) {
        while (userList.getUsersEligibleToStartChat(user).isEmpty() || chats.contains(user.getChat())) {
            waitForChat();
        }
        User otherUser = userList.getUsersEligibleToStartChat(user).get(0);
        Chat chat = new Chat(user, otherUser);
        chats.add(chat);
        user.setChat(chat);
        otherUser.setChat(chat);
        System.out.println(user.getName() + " start chat with " + otherUser.getName());
    }

    public void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        chats.remove(chat);
        User user1 = chat.getFirstUser();
        User user2 = chat.getSecondUser();
        user1.resetChat();
        user2.resetChat();
        notifyAll();
        System.out.println(user1.getName() + " end chat with " + user2.getName());
    }
}
