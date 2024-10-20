package school.faang.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class Chat {
    private final int chatId;
    private final User user1;
    private final User user2;
    private final Map<User, List<Message>> userMessages = new HashMap<>();

    public Chat(User user1, User user2) {
        this.chatId = generateId(user1, user2);
        this.user1 = user1;
        this.user2 = user2;
        userMessages.put(user1, new ArrayList<>());
        userMessages.put(user2, new ArrayList<>());
    }

    public synchronized boolean sendMessage(Message message) {
        validateMessage(message);
        System.out.println("Пользователь " + message.getMessageOwner() +
                " отправил сообщение: " + message.getContent());
        return userMessages.get(message.getMessageOwner()).add(message);
    }

    public synchronized boolean removeMessage(Message message) {
        validateMessage(message);
        System.out.println("Пользователь " + message.getMessageOwner() +
                " удалил сообщение: " + message.getContent());
        return userMessages.get(message.getMessageOwner()).remove(message);
    }

    private void validateMessage(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message не может быть null");
        }
        if (!userMessages.containsKey(message.getMessageOwner())) {
            throw new IllegalArgumentException("Пользователь " + message.getMessageOwner()
                    + " не является участником чата");
        }
    }

    private int generateId(User user1, User user2) {
        int minId = Math.min(user1.getUserId(), user2.getUserId());
        int maxId = Math.max(user1.getUserId(), user2.getUserId());
        return Objects.hash(minId, maxId);
    }

    @Override
    public String toString() {
        return chatId + ": " + user1.getName() + " -> " + user2.getName();
    }
}
