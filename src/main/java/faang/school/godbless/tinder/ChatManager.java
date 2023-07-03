package faang.school.godbless.tinder;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ChatManager {

    private final static int WAITING_COUNTER_MAX = 10;
    private final UserList userList;
    private List<User> onlineUsers;
    private List<Chat> chats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.onlineUsers = userList.getOnlineUsers();
        this.chats = new ArrayList<>();
    }

    public void startChat(User user) {
        synchronized (userList) {
            User userToChat = findUserToChatWith(user);

            if (userToChat != null) {
                System.out.println(user.getName() + " is searching for chat");
                userList.removeFromUserLiked(user, userToChat);
                userList.removeFromUserLiked(userToChat, user);
                Chat chat = new Chat(user, userToChat);
                chats.add(chat);
            } else {
                waitForChat(user);
            }
        }
    }

    public void endChat(User user) {
        synchronized (userList) {
            Chat chat = chats.stream()
                    .filter((u) -> userIsChatting(user))
                    .findFirst()
                    .orElse(null);

            if (chat != null) {
                chats.remove(chat);
                System.out.println("Chat ended between " + chat.getUser().getName() + " and " + chat.getUserToChat().getName());
            }
        }
    }

    private void waitForChat(User user) {
        synchronized (userList) {
            try {
                System.out.println(user.getName() + " is waiting for chat...");
                userList.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (user.getWaitingCounter() != WAITING_COUNTER_MAX) {
                user.incrementCounter();
                startChat(user);
            } else {
                System.out.println(user.getName() + " you should try again");
                user.setWaitingCounter(0);
            }
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
                return true;
            }
        }

        return false;
    }
}
