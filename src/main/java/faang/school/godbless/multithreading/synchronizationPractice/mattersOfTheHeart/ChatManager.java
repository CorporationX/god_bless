package faang.school.godbless.multithreading.synchronizationPractice.mattersOfTheHeart;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {

    @Getter
    private final UserList userList;
    private List<Chat> chats = new ArrayList<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized void startChat(User user) {
        while (userList.getUsersEligibleToStartChat(user).isEmpty() || (!chats.isEmpty() && chats.contains(user))) {
            waitForChat(user);
        }
        User otherUser = userList.getUsersEligibleToStartChat(user).get(0);
        Chat chat = new Chat(user, otherUser);
        user.setChatting(true);
        otherUser.setChatting(true);
        user.setWantsToChat(false);
        otherUser.setWantsToChat(false);
        chats.add(chat);
        System.out.println(user.getName() + " start chat with " + otherUser.getName());
    }

    public void waitForChat(User user) {
        try {
            user.setWantsToChat(true);
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = chats.stream().filter(chat1 -> chats.contains(user)).findFirst().orElse(null);
        chat.getFirstUser().resetChat();
        chat.getSecondUser().resetChat();
        chats.remove(chat);
        notifyAll();
        System.out.println(chat.getFirstUser().getName() + " end chat with " + chat.getSecondUser().getName());

    }
}
