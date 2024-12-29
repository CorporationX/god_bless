package school.faang.bjs249194;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Getter
public class ChatService {
    private final Set<Chat> chats = new LinkedHashSet<>();
    private final UserList userList = new UserList();

    public synchronized void connectToChat(Chat chat) {
        User user2;
        try {
            user2 = waitSingleUser(chat);
        } catch (InterruptedException e) {
            log.error("Wait user Interrupted, {}", e.getMessage());
            return;
        }
        chat.connect(user2);
    }

    public synchronized void addChat(Chat chat) {
        chats.add(chat);
        this.notifyAll();
        log.info("New chat available! {}", chat);
    }

    public synchronized void connectAndWaitChat(User user) {
        log.info("User = {} waiting for chat...", user);
        Chat chat;
        try {
            chat = waitFreeChat(user);
        } catch (InterruptedException e) {
            log.error("Wait chat Interrupted, {}", e.getMessage());
            return;
        }
        log.info("waitForChat find chat! chat = {}", chat);
        chat.connect(user);
    }

    private Chat waitFreeChat(User user) throws InterruptedException {
        List<Chat> freeChats = getFreeChatsWithout(user);

        if (freeChats.isEmpty()) {
            ConcurrencyUtils.tryWait(this);
            if (!user.isUserLookingForChat()) {
                throw new InterruptedException("User is already find Chat!");
            }
            return waitFreeChat(user);
        }
        return freeChats.get(0);
    }

    public synchronized void removeChat(Chat chat) {
        chats.remove(chat);
    }

    public synchronized void printChats() {
        chats.forEach(System.out::println);
    }

    private List<Chat> getFreeChatsWithout(User user) {
        return chats.stream()
                .filter(chat -> chat.isEmptyUser2() && !chat.getHostUser().equals(user))
                .toList();
    }

    private User waitSingleUser(Chat chat) throws InterruptedException {
        List<User> users = userList.getOnlineAndLookingForChatUsers().stream()
                .filter(u -> !u.equals(chat.getHostUser())).toList();
        if (users.isEmpty()) {
            ConcurrencyUtils.tryWait(userList);
            if (!chat.isEmptyUser2()) {
                throw new InterruptedException("Чат уже занят");
            }
            return waitSingleUser(chat);
        }
        return users.get(0);
    }
}
