package faang.school.godbless.alexbulgakoff.multithreading.synchronization.mattersoftheheart;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */

@Getter
@ToString
public class Chat {
    private final User firstUserForChat;
    private final User secondUserForChat;

    public Chat(User firstUserForChat, User secondUserForChat) {
        this.firstUserForChat = firstUserForChat;
        this.secondUserForChat = secondUserForChat;
        firstUserForChat.setConsentToChat(true);
        secondUserForChat.setConsentToChat(true);
    }
}
