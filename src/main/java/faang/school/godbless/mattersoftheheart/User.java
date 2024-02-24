package faang.school.godbless.mattersoftheheart;

public class User {

    private final String name;
    private boolean isOnline = true;
    private boolean wantsToChat;

    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean wantsToChat() {
        return wantsToChat;
    }

    public void setWantsToChat(boolean wantsToChat) {
        this.wantsToChat = wantsToChat;
    }

}
