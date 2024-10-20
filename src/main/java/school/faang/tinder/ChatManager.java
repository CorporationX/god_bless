package school.faang.tinder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.tinder.exceptions.UserAlreadyInChatException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Slf4j
public class ChatManager {
    private final UserList userList;
    private final Map<Integer, Chat> chatIdToChat = new HashMap<>();

    public synchronized int startChat(User user) throws UserAlreadyInChatException {
        validateUser(user);
        Random random = new Random();
        List<User> interlocutorCandidates = getInterlocutorCandidates(user);
        while (interlocutorCandidates.isEmpty()) {
            try {
                System.out.println("На данный момент нет доступных собеседников");
                this.wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
            interlocutorCandidates = getInterlocutorCandidates(user);
        }
        User interlocutor = interlocutorCandidates.get(random.nextInt(interlocutorCandidates.size()));
        Chat chat = new Chat(user, interlocutor);
        chatIdToChat.put(chat.getChatId(), chat);
        switchChatSearchStatusForIntelocutors(user, interlocutor);
        System.out.println("Чат " + chat + " ,был запущен!");
        return chat.getChatId();
    }

    private static void switchChatSearchStatusForIntelocutors(User user1, User user2) {
        user1.setLookingForChat(!user1.isLookingForChat());
        user2.setLookingForChat(!user2.isLookingForChat());
    }

    public synchronized void endChat(int chatId) {
        if (!chatIdToChat.containsKey(chatId)) {
            System.out.println("Чат " + chatId + " был удален");
        }
        Chat removedChat = chatIdToChat.remove(chatId);
        switchChatSearchStatusForIntelocutors(removedChat.getUser1(), removedChat.getUser2());
        System.out.println("Чат " + removedChat + " был завершен");
        userList.notifyAll();
    }

    public Chat getChat(int chatId) {
        return chatIdToChat.get(chatId);
    }

    private List<User> getInterlocutorCandidates(User user) {
        Set<User> userInChats = chatIdToChat.values().stream()
                .flatMap(chat -> Stream.of(chat.getUser1(), chat.getUser2()))
                .collect(Collectors.toSet());
        return userList.getOnlineUsers().stream()
                .filter(currUser -> !user.equals(currUser) && !userInChats.contains(currUser))
                .toList();
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
