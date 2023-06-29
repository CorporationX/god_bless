package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;


public class ChatManager {

    private final static int COUNTER_MAX = 10;
    private final UserList userList;
    private List<User> onlineUsers;
    private List<Chat> chats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.onlineUsers = userList.getOnlineUsers();
        this.chats = new ArrayList<>();
    }

    public synchronized void startChat(User user) {
        User userToChat = findUserToChatWith(user);

        if (userToChat != null) {
            System.out.println(user.getName() + " is searching for chat");
            userList.removeFromUserLiked(user, userToChat);
            userList.removeFromUserLiked(userToChat, user);
            Chat chat = new Chat(user, userToChat);
            chats.add(chat);
            try {
                wait(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            endChat(user);
        } else {
            waitForChat(user);
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = chats.stream()
                .filter((u) -> userIsChatting(user))
                .findFirst()
                .orElse(null);

        chats.remove(chat);
        userList.notifyAll();
        System.out.println("Chat ended between " + chat.getUser().getName() + " and " + chat.getUserToChat().getName());
    }

    private synchronized void waitForChat(User user) {
        try {
            System.out.println(user.getName() + " is waiting for chat...");
            userList.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (user.getWaitingCounter() != COUNTER_MAX) {
            user.incrementCounter();
            startChat(user);
        } else {
            System.out.println(user.getName() + " you should try again");
            user.setWaitingCounter(0);
        }
    }

    private synchronized User findUserToChatWith(User user) {
        if (userIsChatting(user)) {
            return null;
        }

        return onlineUsers.stream()
                .filter(u -> u.wantToChatWith(user) && user.wantToChatWith(u))
                .filter(u -> !userIsChatting(u))
                .findFirst()
                .orElse(null);
    }

    private boolean userIsChatting(User user) {
        for (Chat chat : chats) {
            if (chat.getUser().equals(user) || chat.getUserToChat().equals(user)) {
                System.out.println(user.getName() + " already chatting");
                return true;
            }
        }

        return false;
    }
}
