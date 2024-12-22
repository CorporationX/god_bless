package school.faang.sprint_3.task_49494;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat {
    private int chatId;
    private User user1;
    private User user2;

    public Chat(int chatId) {
        this.chatId = chatId;
    }

    public synchronized void setUser(User user) {
        if (user.equals(this.user1) || user.equals(this.user2)) {
            log.info("{} уже подключен к этому чату", user.getName());
            return;
        }

        if (this.user1 == null) {
            log.info("{} подключился в первую ячейку", user.getName());
            setUser1(user);
        } else if (this.user2 == null) {
            log.info("{} подключился во вторую ячейку", user.getName());
            setUser2(user);
        } else {
            log.info("Места для пользователя нет");
        }
    }

    public synchronized void disconnectUsers() {
        this.user1 = null;
        this.user2 = null;
    }
}
