package Multithreading.bc3012;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatManager {
    private UserList userList;
    private List<Chat> chatList;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chatList = new ArrayList<>();
    }

    public synchronized void startChat(User userLookingForChat) {
        if (userContainsChats(userLookingForChat).isEmpty()) {
            List<User> besidesCurrent = userList.getOnlineUsers().stream()
                    .filter(user -> !user.equals(userLookingForChat))
                    .toList();
            if (besidesCurrent.size() > 0) {
                User user2 = besidesCurrent.get(0);
                userList.addUsersToChat(userLookingForChat, user2);
                chatList.add(new Chat(userLookingForChat, user2));
                System.out.printf("Chat between %s and %s has been started\n", userLookingForChat.getName(), user2.getName());
            } else {
                waitForChat(userLookingForChat);
            }
        } else {
            System.out.println(userLookingForChat.getName() + " need to finish chatting first");
        }
    }

    public synchronized void waitForChat(User user) {
        if (userContainsChats(user).isEmpty()) {
            System.out.println(user.getName() + " is waiting for chat");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized List<Chat> userContainsChats(User user) {
        return chatList.stream()
                .filter(chat -> chat.getUser1() == user || chat.getUser2() == user)
                .toList();
    }

    public synchronized void endChat(User user) {
        Chat chat = userContainsChats(user).get(0);
        chatList.remove(chat);
        userList.addUsersToList(chat);
        System.out.printf("Chat between %s and %s has been finished\n",
                chat.getUser1().getName(), chat.getUser2().getName());
        notifyAll();
    }

    public void emulateChatting(User user) {
        startChat(user);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!userContainsChats(user).isEmpty()) {
            endChat(user);
        }
    }
}
