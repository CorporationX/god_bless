package school.faang.tinder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Chat {
    private final User user1;
    private final User user2;
    private final List<String> messages = new ArrayList<>();
    private boolean isActive = true;
    private final Object lock = new Object();

    public void sendMessage(User sender, String message) {
        synchronized (lock) {
            if (!isActive) {
                throw new IllegalStateException("Чат не активный");
            }
            if (sender != user1 && sender != user2) {
                throw new IllegalArgumentException("Пользователь не участник чата");
            }
            messages.add(sender.getName() + ": " + message);
            log.info("{} отправил сообщение: {}", sender.getName(), message);
        }
    }

    public void endChat() {
        synchronized (lock) {
            if (!isActive) {
                return;
            }
            isActive = false;
            user1.setLookingForChat(true);
            user2.setLookingForChat(true);
        }
    }

    public boolean isActive() {
        synchronized (lock) {
            return isActive;
        }
    }

    public User getOtherUser(User user) {
        synchronized (lock) {
            if (user == user1) {
                return user2;
            }
            if (user == user2) {
                return user1;
            }
            throw new IllegalArgumentException("Пользователь не участник чата");
        }
    }
}
