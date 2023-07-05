package matters_of_the_heart;

public class User {
    private String name;
    private boolean isOnline;
    private boolean wantsToChat;
    private boolean wantsToShowOnline;
    private boolean isChatting;
    private Chat chat;

    public User(String name, boolean isOnline, boolean wantsToChat, boolean wantsToShowOnline, boolean isChatting) {
        this.name = name;
        this.isOnline = isOnline;
        this.wantsToChat = wantsToChat;
        this.wantsToShowOnline = wantsToShowOnline;
        this.isChatting = isChatting;
        this.chat = null;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isWantsToChat() {
        return wantsToChat;
    }

    public boolean isWantsToShowOnline() {
        return wantsToShowOnline;
    }

    public boolean isChatting() {
        return isChatting;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
        this.isChatting = true;
    }

    public void resetChat() {
        this.chat = null;
        this.isChatting = false;
    }

    public boolean isEligible(){
        return isOnline && wantsToChat && wantsToShowOnline && !isChatting;
    }
}
