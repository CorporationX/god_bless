package school.faang.task49140;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @EqualsAndHashCode.Include
    private String name;
    private boolean isOnline;
    private boolean isLookingChat;

    public boolean changeStatus(Status status) {
        if (status == Status.ONLINE) {
            isOnline = true;
        } else if (status == Status.OFFLINE) {
            isOnline = false;
        }
        log.info("{} сменил статус на {}", name, status);

        return isOnline;
    }

    public boolean lookingForChat(Status status) {
        if (status == Status.CHAT) {
            isLookingChat = true;
        } else if (status == Status.NO_CHAT) {
            isLookingChat = false;
        }

        log.info("{} сменил статус чата на {}", name, status);

        return isLookingChat;
    }
}
