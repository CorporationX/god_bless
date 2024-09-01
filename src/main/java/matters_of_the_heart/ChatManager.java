package matters_of_the_heart;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
public class ChatManager {

    private final UserList userList;
    private final Set<User> usersAlreadyChatting = Collections.synchronizedSet(new HashSet<>());
    private final List<Chat> chats = Collections.synchronizedList(new ArrayList<>());
    private int chatIdCounter = 0;

    public synchronized void startChat(User user) {
        System.out.println(usersAlreadyChatting);
        User userToChat = userList.getOnlineUsers().stream()
                .filter(u -> !Objects.equals(user.getId(), u.getId()))
                .filter(u -> !usersAlreadyChatting.contains(u))
                .findAny()
                .orElse(null);
        if (userToChat == null) {
            waitForChat();
        } else {
            Chat chat = new Chat(++chatIdCounter, user, userToChat);
            usersAlreadyChatting.add(user);
            usersAlreadyChatting.add(userToChat);
            chats.add(chat);
            System.out.println(chat);
        }
    }

    public synchronized void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void endChat(User user) {
        Chat chatToEnd = chats.stream()
                .filter(chat -> Objects.equals(user.getId(), chat.getFirstUser().getId()) ||
                        Objects.equals(user.getId(), chat.getSecondUser().getId()))
                .findAny()
                .orElse(null);
        if (chatToEnd != null) {
            chats.remove(chatToEnd);
            usersAlreadyChatting.remove(chatToEnd.getFirstUser());
            usersAlreadyChatting.remove(chatToEnd.getSecondUser());
            notifyAll();
        }
    }
}
