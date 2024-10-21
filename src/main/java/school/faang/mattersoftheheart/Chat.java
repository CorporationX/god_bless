package school.faang.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;

    public void displayChatInfo() {
        System.out.println(user1.getName() + " is chatting with " + user2.getName());
    }
}
