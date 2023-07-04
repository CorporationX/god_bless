package faang.school.godbless.multithreading.heart_matters;

import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {
    private User user1;
    private User user2;
    private ChatManager chatManager;

    public void startChat() {
        System.out.println(user1.getName() + " and " + user2.getName() + " are chatting");

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        chatManager.endChat(this);
    }
}
