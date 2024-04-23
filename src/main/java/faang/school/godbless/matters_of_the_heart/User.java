package faang.school.godbless.matters_of_the_heart;

import lombok.Data;

@Data
public class User {
    private String name;
    private Chat currentChat;

    public void joinChat(Chat chat) {
        currentChat = chat;
    }

    public void leaveChat() {
        currentChat = null;
    }

    public User(String name) {
        this.name = name;
    }
}