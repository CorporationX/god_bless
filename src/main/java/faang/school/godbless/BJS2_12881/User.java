package faang.school.godbless.BJS2_12881;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    private final String name;
    @Setter
    private boolean isOnline;
    @Setter
    private boolean isChatting;
    @Setter
    private boolean wantsChatting;
    private Chat chat;

    public User(String name) {
        this.name = name;
        isOnline = true;
        isChatting = false;
        wantsChatting = true;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
        this.isChatting = true;
        this.wantsChatting = false;
        this.isOnline = true;
    }

    public void leaveChat() {
        this.chat = null;
        this.isChatting = false;
        int probability = Rand.RAND.nextInt(10);
        this.wantsChatting = probability < 8;
        this.isOnline = true;
    }

    public boolean isAvailableForChat() {
        return isOnline && !isChatting && wantsChatting;
    }
}
