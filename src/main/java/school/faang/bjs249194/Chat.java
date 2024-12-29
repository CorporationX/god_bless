package school.faang.bjs249194;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Slf4j
public class Chat {
    private User hostUser;
    private User user2;

    public Chat(User hostUser) {
        this.hostUser = hostUser;
    }

    public boolean isEmptyUser2() {
        boolean isEmpty = this.user2 == null;
        if (!isEmpty) {
            log.info("Чат уже занят: {}", this);
        }
        return isEmpty;
    }

    public void connect(User user2) {
        this.user2 = user2;
        user2.setLookingForChat(false);
        log.info("Чат сформирован {}", this);
    }
}
