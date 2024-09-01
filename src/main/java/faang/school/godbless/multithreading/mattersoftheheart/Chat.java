package faang.school.godbless.multithreading.mattersoftheheart;

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

        System.out.printf("> created chat between %s and %s%n", firstUser.getName(), secondUser.getName());
    }

    public void doChat(User user, String message) {
        String formattedMessage = user.getName() + ": " + message;

        chat.get(firstUser).add(formattedMessage);
        chat.get(secondUser).add(formattedMessage);

        System.out.printf("> %s send message: %s%n", user.getName(), message);
    }

}
