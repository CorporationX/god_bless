package faang.school.godbless.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ChatManager {
    private UserList users;
    private final Map<String, Chat> chats = new HashMap<>();

    public void joinRandomChat(User user) throws InterruptedException {
        users.waitForChat(user);

        startChatBetweenTwoUsers();
    }

    public void startChatBetweenTwoUsers() throws InterruptedException {
        synchronized (users.getWaitingUsers()) {
            if (users.getWaitingUsers().size() < 2) {
                users.wait();
            }

            User firstUser = users.getWaitingUsers().poll();
            User secondUser = users.getWaitingUsers().poll();

            if (firstUser == null || secondUser == null) {
                throw new IllegalArgumentException("no such users");
            }

            Chat chat = new Chat(UUID.randomUUID().toString(), List.of(firstUser, secondUser));

            chats.put(chat.id(), chat);
        }
    }

    public void endChat(String chatId) {
        chats.remove(chatId);
    }
}
