package school.faang.m1s3.bjs2_37459_tinder;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ChatManager {
    private final Object lock = new Object();
    private UserList userList;
    private Map<User, Chat> activeChats = new HashMap<>();
    private List<User> usersChatting = new ArrayList<>();

    public ChatManager(UserList userlist) {
        this.userList = userlist;
    }

    public Chat startChat(User user) {
        synchronized (lock) {
            user.setOnline(true);
            user.setLookingForChat(true);

            while (true) {
                List<User> lookingForChat = userList.getOnlineUsers().stream()
                        .filter(u -> !u.equals(user))
                        .filter(User::isLookingForChat)
                        .toList();

                if (!lookingForChat.isEmpty()) {
                    User user2 = lookingForChat.get(0);
                    Chat newChat = new Chat(user, user2);
                    newChat.setName(user.getName() + "'s chat");
                    activeChats.put(user, newChat);
                    activeChats.put(user2, newChat);
                    user.setLookingForChat(false);
                    user2.setLookingForChat(false);
                    usersChatting.add(user);
                    usersChatting.add(user2);
                    System.out.printf("Chat between %s and %s has started%n", user.getName(), user2.getName());
                    return newChat;
                }
                try {
                    System.out.println(user.getName() + ", no one is free for chat at the moment. You're placed in waiting list");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void waitForChat(User user) {
        synchronized (lock) {
            if (user.isOnline() && activeChats.containsKey(user)) {
                System.out.println(user.getName() + " is busy right now");
            } else if (!user.isOnline()) {
                System.out.println(user.getName() + " is offline");
            }
        }
    }

    public void endChat(User user) {
        synchronized (lock) {
            if (activeChats.containsKey(user)) {
                Chat chat = activeChats.get(user);
                activeChats.remove(user);
                activeChats.remove(chat.getUser2());
                usersChatting.remove(chat.getUser1());
                usersChatting.remove(chat.getUser2());
                chat.getUser1().setLookingForChat(false);
                chat.getUser2().setLookingForChat(true);
                lock.notify();
                System.out.printf("Chat between %s and %s has ended%n",
                        chat.getUser1().getName(), chat.getUser2().getName());
            }
        }
    }
}
