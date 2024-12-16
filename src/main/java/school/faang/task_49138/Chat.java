package school.faang.task_49138;

import lombok.Data;

@Data
public class Chat {
    private User firstUserToChat;
    private User secondUserToChat;

    public Chat(User firstUserToChat, User secondUserToChat) {
        this.firstUserToChat = firstUserToChat;
        this.secondUserToChat = secondUserToChat;
        System.out.println("Chat was started! " + firstUserToChat + " : " + secondUserToChat);
    }

    public void endChat() {
        System.out.println("Chat was ended! " + firstUserToChat + " + " + secondUserToChat);
    }
}
