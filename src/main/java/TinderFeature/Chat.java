package TinderFeature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Chat {
    private User user1;
    private User user2;
    private List<String> messages;


    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}
