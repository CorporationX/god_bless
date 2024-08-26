package heart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class User {
    @NonNull
    private final String name;
    private boolean isOnline = true;
    private Chat currentChat;

    public void sendMessage(@NonNull Message message) {
        if (currentChat == null) {
            throw new IllegalArgumentException("User not in any chat");
        }
        currentChat.sendMessage(message, name);
    }

    public void setUserOnline() {
        isOnline = true;
    }

    public void setUserOffline() {
        currentChat = null;
        isOnline = false;
    }

    public synchronized void setCurrentChat(Chat chat) {
        if (chat == null) {
            log.error("User not in any chat");
        }
        currentChat = chat;
    }
}
