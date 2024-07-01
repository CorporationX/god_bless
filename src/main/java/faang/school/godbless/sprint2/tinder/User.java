package faang.school.godbless.sprint2.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Getter
@Slf4j
public class User {
    private int id;
    private String username;
    private boolean waitChat;
    private boolean isOnline;

    public void setWaitChat(boolean waitChat) {
        if (isOnline) {
            this.waitChat = waitChat;
        } else {
            log.error("Невозможно установить ожидание чата оффлайн пользователю. Wait state: " + this.isWaitChat());
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("waitChat=" + waitChat)
                .add("isOnline=" + isOnline)
                .toString();
    }
}
