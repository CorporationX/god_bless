package school.faang.tinder;

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

    public synchronized Message sendMessage(String content, User messageOwner) {
        validateMessageContent(content);
        validateMessageOwner(messageOwner);
        System.out.println("Пользователь " + messageOwner +
                " отправил сообщение: " + content);
        Message message = new Message(messageOwner, content, chatId);
        userMessages.get(messageOwner).add(message);
        return message;
    }

    public synchronized void removeMessage(Message message) {
        validateMessage(message);
        System.out.println("Пользователь " + message.messageOwner() +
                " удалил сообщение: " + message.content());
        userMessages.get(message.messageOwner()).remove(message);
    }

    public boolean containsUser(User user) {
        return userMessages.containsKey(user);
    }

    private void validateMessage(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("message не может быть null");
        }
    }

    private void validateMessageContent(String message) {
        if (message == null) {
            throw new IllegalArgumentException("message не может быть null");
        }
    }

    private void validateMessageOwner(User messageOwner) {
        if (messageOwner == null) {
            throw new IllegalArgumentException("messageOwner не может быть null");
        }
        if (!userMessages.containsKey(messageOwner)) {
            throw new IllegalArgumentException("Пользователь " + messageOwner.getName()
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
