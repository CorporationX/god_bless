package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task11;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class ChatManager {

    private final List<Chat> chatList = new ArrayList<>();

    private final UserList userList;

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    @SneakyThrows
    public synchronized void startChat(User user) {
        userList.deleteOfflineUser();

        Optional<User> userChat;
        while ((userChat = getUserWantToChat(user)).isEmpty()) {
            System.out.println(user + " ждет других пользователей для чата ...");
            wait();
        }

        User otherUser = userChat.get();
        System.out.println(user + " и " + otherUser + " начали чат");
        Chat chat = new Chat(user, otherUser);
        user.setWantToStartChat(false);
        otherUser.setWantToStartChat(false);
        chatList.add(chat);
    }

    @SneakyThrows
    public synchronized void waitForChat(User user) {
        while (chatList.stream()
                .noneMatch(chat -> chat.getUser1().equals(user) || chat.getUser2().equals(user))) {
            System.out.println(user + " не участвует ни в одном чате");
            wait();
        }
    }

    public synchronized void endChat(Chat chat) {
        System.out.println(chat.getUser1() + " и " + chat.getUser2() + " закончили чат");
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
