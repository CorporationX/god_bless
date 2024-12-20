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

    public void setUser(User user) {
        if (this.user1 == null) {
            log.info("{} подключился в первую ячейку", user.getName());
            setUser1(user);
        } else if (this.user2 == null) {
            log.info("{} подключился во вторую ячейку", user.getName());
            setUser2(user);
        } else {
            System.out.println("Места для пользователя нет");
        }
    }

    public synchronized void disconnectUsers() {
        this.user1 = null;
        this.user2 = null;
    }
}
