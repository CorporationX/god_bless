package faang.school.godbless.matters_of_heart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class ChatManager {

    private List<Chat> chatList = new ArrayList<>();
    private final UserList userList;

    public synchronized void startChat(User user) {
        Optional<User> userChat;
        while ((userChat = getUserWantToChat(user)).isEmpty()) {
            System.out.println(user + " waits for a chat");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        User otherUser = userChat.get();
        System.out.println(user + " and " + otherUser + " started a chat");
        Chat chat = new Chat(user, otherUser);
        user.setWantToStartChat(false);
        otherUser.setWantToStartChat(false);
        chatList.add(chat);
    }

    public synchronized void waitForChat(User user) {
        boolean userInChat = chatList.stream()
                .anyMatch(chat -> chat.getUser1().equals(user) || chat.getUser2().equals(user));
        while (!userInChat) {
            System.out.println(user + " isn't in a chat");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void endChat(Chat chat) {
        System.out.println(chat.getUser1() + " and " + chat.getUser2() + " finished chat");
        chatList.remove(chat);
        chat.removeUserChat();
        notifyAll();
    }

    private Optional<User> getUserWantToChat(User user) {
        return userList.getOnlineUsers().stream()
                .filter(x -> !x.equals(user))
                .filter((User::isWantToStartChat))
                .findAny();
    }
}
