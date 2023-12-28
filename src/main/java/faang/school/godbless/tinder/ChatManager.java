package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private UserList userList;
    private List<Chat> chatList;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chatList = new ArrayList<>();
    }

    public synchronized void startChat(User user) throws InterruptedException {
        while (!findChatFor(user)) {
            wait();
        }
    }

    private boolean findChatFor(User user) {
        for (User onlineUser : userList.getOnlineUsers()) {
            if (onlineUser.equals(user)) {
                continue;
            }
            if (isAlreadyInChat(onlineUser)) {
                continue;
            }

            if (onlineUser.isWantTalk()) {
                chatList.add(new Chat(user, onlineUser));
                System.out.printf("Chat between %s and %s was created \n", user.getName(), onlineUser.getName());
                notifyAll();
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyInChat(User user) {
        return chatList.stream().anyMatch(s -> (s.getUser1().equals(user)) || (s.getUser2().equals(user)));
    }

    public synchronized void endChat(User user) {
        Chat chat = chatList.stream()
                .filter(s -> (s.getUser1().equals(user)) || (s.getUser2().equals(user))).findAny().orElse(null);
        System.out.printf("Chat between %s and %s was finished \n", chat.getUser1().getName(), chat.getUser2().getName());
        chatList.remove(chat);
        notifyAll();
    }
}
