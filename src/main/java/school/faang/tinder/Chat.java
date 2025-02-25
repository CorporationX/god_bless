package school.faang.tinder;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Chat {

    private final User firstUser;
    private final User secondUser;
    private final List<String> messages;
    private boolean isActive;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.messages = new ArrayList<>();
        this.isActive = true;
    }

    public void sendMessage(User sender, String text) {
        if (!isActive) {
            log.info("Чат заблокирован одним из пользователей. Отправка сообщений невозможна");
            return;
        }
        if (!sender.equals(firstUser) || !sender.equals(secondUser)) {
            log.warn("Пользователь {} не является участником этого чата", sender.getName());
        }
        messages.add(sender.getName() + ": " + text);
        log.info("{} отправил: {}", sender.getName(), text);
    }

    public List<String> getAllMessages() {
        return messages.stream().toList();
    }

    public void blockChat() {
        isActive = false;
        log.info("Чат остановлен!");
    }
}
