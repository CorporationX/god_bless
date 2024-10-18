package school.faangSprint3.t11;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Chat {
    private final User user1;
    private final User user2;
    private final List<Message> messages = Collections.synchronizedList(new ArrayList<>());

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        messages.add(new Message(null, "Чат начат между " + user1.getName() + " и " + user2.getName()));
    }

    public synchronized void sendMessage(User sender, String content) {
        Message message = new Message(sender, content);
        messages.add(message);
        System.out.println(message);
    }
}