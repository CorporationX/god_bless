package school.faang.module1.bjs2_81781;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Chat {
    private final User user1;
    private final User user2;

    public void start() {
        log.info("Создан новый чат: {} - {}", user1.getName(), user2.getName());
    }

    public void end() {
        log.info("Чат {} - {} завершен", user1.getName(), user2.getName());
    }

    public boolean contains(User user) {
        return user1.equals(user) || user2.equals(user);
    }
}