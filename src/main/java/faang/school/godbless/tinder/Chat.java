package faang.school.godbless.tinder;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class Chat {
    private ChatManager chatManager;
    private User firstUser;
    private User secondUser;

    public Chat(ChatManager chatManager, User firstUser) {
        this.chatManager = chatManager;
        this.firstUser = firstUser;
    }

    public void startConversation() {
        System.out.println(firstUser.getName() + " and " + secondUser.getName() + " are chatting.");
    }

    public void deliverMessage() {
        int whoSends = ThreadLocalRandom.current().nextInt(2);
        if (whoSends == 0) {
            System.out.println(firstUser.getName() + " sends message to " + secondUser.getName());
        } else {
            System.out.println(secondUser.getName() + " sends message to " + firstUser.getName());
        }
    }

    public void isItTimeToCloseConversation() {
        boolean isConversationSuccessful = ThreadLocalRandom.current().nextBoolean();

        if (!isConversationSuccessful) {
            System.out.println("It is time to close conversation");
            chatManager.endChat();
        } else {
            System.out.println("It is too early to close conversation");
        }
    }
}
