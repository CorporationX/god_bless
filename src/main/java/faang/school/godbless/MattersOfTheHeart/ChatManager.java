package faang.school.godbless.MattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

@Slf4j
@AllArgsConstructor
@Getter
public class ChatManager {
    private final Map<Chat, Boolean> chatsWithHisTopCapacity = new HashMap<>();
    private final Queue<User> usersToStartChat = new LinkedList<>();
    private UserList userList;

    public Optional<Chat> startChat(@NonNull User user, int topAmountOfUsers) {
        Chat chat;
        synchronized (usersToStartChat) {
            if (!waitForChat(user)) return Optional.empty();

            Optional<Chat> optionalChat = getExistingChatForEntry(user, topAmountOfUsers);
            if (optionalChat.isPresent()) {
                chat = optionalChat.get();
                userAddToExistChat(user, chat);
            } else {

                chat = new Chat(topAmountOfUsers);
                findNewUsersToStartChat(topAmountOfUsers).forEach(getUser -> userAddToExistChat(getUser, chat));
            }
            return Optional.of(chat);
        }
    }

    private Optional<Chat> getExistingChatForEntry(@NonNull User userExclude, int topAmountOfUsers) {
        synchronized (chatsWithHisTopCapacity) {
            return chatsWithHisTopCapacity.entrySet().stream()
                    .filter(entry -> !entry.getValue())
                    .filter(entry -> entry.getKey().getTopCapacityOfUsers() > topAmountOfUsers)
                    .filter(entry -> !entry.getKey().getUsers().contains(userExclude))
                    .map(Map.Entry::getKey)
                    .findFirst();
        }
    }

    private List<User> findNewUsersToStartChat(int topAmountOfUsers) {
        List<User> selectedUsers;
        synchronized (usersToStartChat) {
            selectedUsers = usersToStartChat.stream()
                    .limit(topAmountOfUsers)
                    .toList();
            usersToStartChat.removeAll(selectedUsers);
        }
        return selectedUsers;
    }

    private boolean waitForChat(@NonNull User user) {
        synchronized (usersToStartChat) {
            try {
                usersToStartChat.add(user);
                usersToStartChat.notifyAll();

                while (usersToStartChat.size() == 1 && usersToStartChat.contains(user)) {
                    usersToStartChat.wait();
                }
                return true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван: " + e.getMessage());
                return false;
            }
        }
    }

    public void userAddToExistChat(@NonNull User user, @NonNull Chat chat) {
        synchronized (chat) {
            chat.addUserToChat(user);
            boolean statusTopCapacity = chat.permissionByChatCapacity();
            if (statusTopCapacity) {
                synchronized (chatsWithHisTopCapacity) {
                    chatsWithHisTopCapacity.put(chat, statusTopCapacity);
                }
            }
        }
    }

    public void leaveChat(@NonNull User user, @NonNull Chat chat) {
        synchronized (chat) {
            chat.deleteUserFromChat(user);
            if (chat.getUsers().isEmpty()) {
                endChat(chat);
                log.info("Chat ended ({} users)", chat.getUsers().size());
            } else {
                synchronized (chatsWithHisTopCapacity) {
                    boolean statusTopCapacity = chat.permissionByChatCapacity();
                    chatsWithHisTopCapacity.put(chat, statusTopCapacity);
                }
            }
        }
        synchronized (usersToStartChat) {
            usersToStartChat.notifyAll();
        }
    }

    private void endChat(@NonNull Chat chat) {
        synchronized (chatsWithHisTopCapacity) {
            chatsWithHisTopCapacity.remove(chat);
        }
    }
}
