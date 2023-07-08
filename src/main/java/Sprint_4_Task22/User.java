package Sprint_4_Task22;
public class User {
    private String name;
    private boolean isOnline;
    private boolean waitingForChat;
    private boolean waitingToOnline;
    private boolean isChatting;
    private Chat chat;
    public User(String name, boolean isOnline, boolean waitingForChat, boolean waitingToOnline, boolean isChatting) {
        this.name = name;
        this.isOnline = isOnline;
        this.waitingForChat = waitingForChat;
        this.waitingToOnline = waitingToOnline;
        this.isChatting = isChatting;
        this.chat = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isWaitingForChat() {
        return waitingForChat;
    }

    public void setWaitingForChat(boolean waitingForChat) {
        this.waitingForChat = waitingForChat;
    }

    public boolean isWaitingToOnline() {
        return waitingToOnline;
    }

    public void setWaitingToOnline(boolean waitingToOnline) {
        this.waitingToOnline = waitingToOnline;
    }

    public boolean isChatting() {
        return isChatting;
    }

    public void setChatting(boolean chatting) {
        isChatting = chatting;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setChattingTrue(Chat chat) {
        this.chat = chat;
        this.isChatting = true;
    }
    public void removeChatting() {
        this.chat = null;
        this.isChatting = false;
    }
    public boolean getAllIsChatting() {
        return !isChatting && isOnline &&waitingToOnline && waitingForChat;
    }



}
