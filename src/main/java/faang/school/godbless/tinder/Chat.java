package faang.school.godbless.tinder;

import lombok.Getter;

@Getter
public class Chat {

    private User user;
    private User userToChat;

    public Chat(User user, User userToChat) {
        this.user = user;
        this.userToChat = userToChat;
        System.out.println("Chat created between " + user.getName() + " and " + userToChat.getName());
    }
}
