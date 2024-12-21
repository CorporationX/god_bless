package school.faang.task49140;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
public class ChatManager {

    private final Object lockChat = new Object();
    private final Object userWait = new Object();
    private final List<Chat> chats = new ArrayList<>();
    private final UserList users;

    private void changeAllStatus(User user) {
        Objects.requireNonNull(user);

        user.changeStatus(Status.ONLINE);
        user.lookingForChat(Status.CHAT);
    }

    public void startChat(User user) throws InterruptedException {
        changeAllStatus(user);

        log.info("{} начинает чат.", user.getName());

        while (user.isOnline() || user.isLookingChat()) {
            synchronized (lockChat) {
                Chat chat = new Chat(user, null);
                chats.add(chat);
                user.getChats().add(chat);

                synchronized (userWait) {
                    userWait.notifyAll();
                }

                while (chat.getUser2() == null || users.getOnlineUser().isEmpty()) {
                    log.info("{} ожидает начала чата.", user.getName());
                    lockChat.wait();
                }
                log.info("Создался чат между юзерами: {} {}",
                        chat.getUser1().getName(), chat.getUser2().getName());
            }
        }
    }

    public void waitChat(User user) throws InterruptedException {
        changeAllStatus(user);

        synchronized (userWait) {
            Chat chat;

            while (chats.stream().allMatch(Chat::isChatActive)) {
                log.info("{} ждёт доступный чат", user.getName());
                userWait.wait();
            }

            chat = chats.stream().filter(chatUser -> !chatUser.isChatActive()).findFirst().get();

            chat.setChatActive(true);
            chat.setUser2(user);
            user.getChats().add(chat);
        }
        synchronized (lockChat) {
            lockChat.notifyAll();
        }
    }

    public void endChat(Chat chat) {
        Objects.requireNonNull(chat);

        if (chats.contains(chat)) {
            chats.remove(chat);

            chat.getUser1().getChats().remove(chat);
            chat.getUser2().getChats().remove(chat);

            log.info("Чат был завершён.");
        }
    }
}
