package school.faang.tinder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.tinder.exceptions.UserAlreadyInChatException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class ChatManager {
    private final UserList userList;
    private final Map<Integer, Chat> chatIdToChat = new HashMap<>();

    public synchronized int startChat(User user) throws UserAlreadyInChatException {
        validateUser(user);
        Optional<User> interlocutorOptional = userList.getInterlocutorFor(user);
        while (interlocutorOptional.isEmpty()) {
            try {
                System.out.println("На данный момент нет доступных собеседников: " + user.getName());
                this.wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
            System.out.println(user.getName() + " пытается найти чат");
            interlocutorOptional = userList.getInterlocutorFor(user);
        }
        User interlocutor = interlocutorOptional.orElseThrow(() ->
                new IllegalArgumentException("Собеседник не может быть null"));
        Chat chat = new Chat(user, interlocutor);
        chatIdToChat.put(chat.getChatId(), chat);
        switchChatSearchStatusForInterlocutors(user, interlocutor);
        System.out.println("Чат " + chat + " ,был запущен!");
        return chat.getChatId();
    }

    public synchronized void endChat(int chatId) {
        if (!chatIdToChat.containsKey(chatId)) {
            System.out.println("Чат " + chatId + " был удален");
            return;
        }
        Chat removedChat = chatIdToChat.remove(chatId);
        switchChatSearchStatusForInterlocutors(removedChat.getUser1(), removedChat.getUser2());
        System.out.println("Чат " + removedChat + " был завершен");
        this.notifyAll();
    }

    private synchronized void switchChatSearchStatusForInterlocutors(User user1, User user2) {
        user1.switchLookingForChat();
        user2.switchLookingForChat();
    }

    public Chat getChat(int chatId) {
        return chatIdToChat.get(chatId);
    }

    private static void validateUser(User user) throws UserAlreadyInChatException {
        if (user == null) {
            throw new IllegalArgumentException("user не может быть null");
        }
        if (!user.isLookingForChat()) {
            throw new UserAlreadyInChatException();
        }
    }
}
