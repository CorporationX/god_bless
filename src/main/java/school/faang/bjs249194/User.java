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
public class User {
    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;

    public boolean isUserLookingForChat() {
        if (!isLookingForChat) {
            log.info("User already find chat");
        }

        return isLookingForChat;
    }
}
