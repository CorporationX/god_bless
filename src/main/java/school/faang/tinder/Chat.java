package school.faang.tinder;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
public class Chat {

    private final User firstUser;
    private final User secondUser;
    private final Map<User, List<String>> messages;
    private boolean isActive;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.messages = new HashMap<>();
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
        messages.computeIfAbsent(sender, message -> new ArrayList<>()).add(text);
        log.info("{} отправил: {}", sender.getName(), text);
    }

    public List<String> getAllMessages() {
        return messages.entrySet()
                .stream()
                .flatMap(sender -> sender.getValue().stream())
                .toList();
    }

    public List<String> getUserMessages(User user) {
        return messages.entrySet()
                .stream()
                .filter(sender -> sender.getKey().equals(user))
                .flatMap(sender -> sender.getValue().stream())
                .toList();
    }

    public void blockChat() {
        isActive = false;
        log.info("Чат остановлен!");
    }
}
