package school.faang.tinder;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import school.faang.tinder.exceptions.UserAlreadyInChatException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class ChatManager {
    public static final String INCORRECT_LOOKING_FOR_CHAT_STATE_MESSAGE = "Не корректный статус поиска чата: ";

    @Getter
    private final UserList userList;
    private final Map<Integer, Chat> chatIdToChat = new HashMap<>();

    public ChatManager(List<User> users) {
        userList = new UserList(this);
        users.forEach(userList::addUser);
    }

    public int startChat(User user) throws UserAlreadyInChatException {
        synchronized (userList) {
            validateUser(user);
            Optional<User> interlocutorOptional = userList.getInterlocutorFor(user);
            while (interlocutorOptional.isEmpty()) {
                try {
                    System.out.println("На данный момент нет доступных собеседников: " + user.getName());
                    userList.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    log.error(Arrays.toString(e.getStackTrace()));
                }
                if (!user.isLookingForChat()) {
                    return getChatByUser(user).orElseThrow(
                                    () -> new IllegalStateException(INCORRECT_LOOKING_FOR_CHAT_STATE_MESSAGE +
                                            user.getName()))
                            .getChatId();
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
    }

    public void endChat(int chatId) {
        synchronized (userList) {
            if (!chatIdToChat.containsKey(chatId)) {
                System.out.println("Чат " + chatId + " был удален");
                return;
            }
            Chat removedChat = chatIdToChat.remove(chatId);
            switchChatSearchStatusForInterlocutors(removedChat.getUser1(), removedChat.getUser2());
            System.out.println("Чат " + removedChat + " был завершен");
            userList.notifyAll();
        }
    }

    private void switchChatSearchStatusForInterlocutors(User user1, User user2) {
        synchronized (userList) {
            user1.switchLookingForChat();
            user2.switchLookingForChat();
        }
    }

    public Chat getChat(int chatId) {
        return chatIdToChat.get(chatId);
    }

    public boolean isInAnyChat(User user) {
        return getChatByUser(user).isPresent();
    }

    public Optional<Chat> getChatByUser(User user) {
        return chatIdToChat.values().stream()
                .filter(chat -> chat.containsUser(user))
                .findFirst();
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
