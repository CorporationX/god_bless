package faang.school.godbless.sprint3.mattersOfTheHeart;

public class User {

    private String id;
    private String name;
    private Boolean isOnline;
    private Boolean isHaveActiveChat;

    public User(String id, String name, Boolean isOnline, Boolean isHaveActiveChat) {
        this.id = name;
        this.name = name;
        this.isOnline = isOnline;
        this.isHaveActiveChat = isHaveActiveChat;
    }

    public String getName() {
        return name;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public Boolean getHaveActiveChat() {
        return isHaveActiveChat;
    }

    public void setHaveActiveChat(Boolean haveActiveChat) {
        isHaveActiveChat = haveActiveChat;
    }

    public String getId() {
        return id;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isOnline=" + isOnline +
                ", isHaveActiveChat=" + isHaveActiveChat +
                '}';
    }
}

