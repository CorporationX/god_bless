package school.faang.task_49142;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatManager {
    private final Users users;

    public ChatManager(@NonNull Users users) {
        this.users = users;
    }

    public void startChat(@NonNull User initiator) {
        synchronized (users) {
            if (!initiator.isAvailableForChat()) {
                log.info("{} начал общаться в другом потоке.", initiator);
            } else {
                User availableUser = users.getAvailableUser(initiator);
                while (availableUser == null) {
                    log.info("{} ожидает, пока появится доступный юзер.", initiator);
                    waitForChat();
                    availableUser = users.getAvailableUser(initiator);
                }
                Chat chat = new Chat(initiator, availableUser);

                initiator.setChat(chat);
                availableUser.setChat(chat);

                log.info("{} начинает чат с {}.", initiator, availableUser);
            }
        }
    }

    public void waitForChat() {
        try {
            users.wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void endChat(@NonNull User user) {
        synchronized (users) {
            Chat chat = user.getChat();

            if (chat != null) {
                User user1 = chat.user1();
                User user2 = chat.user2();

                user1.resetChat();
                user2.resetChat();

                log.info("{} и {} закончили общаться", user1, user2);

                users.notifyAll();
            } else {
                log.warn("{} ни с кем не общается: либо не успел начать, либо собеседник был передан в метод раньше",
                        user);
            }
        }
    }

}
