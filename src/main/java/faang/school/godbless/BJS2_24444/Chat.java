package faang.school.godbless.BJS2_24444;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Chat {
    private final Map<User, List<String>> chat = new HashMap<>();
    private User firstUser;
    private User secondUser;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        chat.put(firstUser, new ArrayList<>());
        chat.put(secondUser, new ArrayList<>());
        System.out.println("Чат создан между " + firstUser.getName() + " и " + secondUser.getName());
    }

    public void doChat(User user, String message) {
        String formattedMessage = user.getName() + ": " + message;

        chat.get(firstUser).add(formattedMessage);
        chat.get(secondUser).add(formattedMessage);
        System.out.println(user.getName() + " отправил сообщение: " + message);
    }
}
