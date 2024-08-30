package matters.of.heart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private final String name;
    private boolean isOnline;
    @Setter
    private Chat activeChat = null;

    User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public Optional<Chat> getActiveChat() {
        return Optional.ofNullable(this.activeChat);
    }

    public void removeActiveChat() {
        this.activeChat = null;
    }
    
    public void toggleOnline() {
        this.isOnline = !this.isOnline;
    }
}
