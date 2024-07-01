package faang.school.godbless.sprint2.tinder;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Getter
@Slf4j
@ToString
public class Chat {
    private final String id;
    private final User ownerUser;
    private User secondUser;

    public Chat(String id, User ownerUser) {
        this.id = id;
        this.ownerUser = ownerUser;
    }

    public void joinSecondUser(User user) {
        this.secondUser = user;
        log.info(String.format("%s присоединился к чату %s", user.getUsername(), id));
        start();
    }

    private void start() {
        if (ownerUser != null && secondUser != null) {
            updateUserState();
            log.info(String.format("%s стартовал с |%s| и |%s|", id, ownerUser.getUsername(), secondUser.getUsername()));
        }
    }

    private void updateUserState() {
        ownerUser.setWaitChat(false);
        secondUser.setWaitChat(false);
    }
}
