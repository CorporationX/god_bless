package faang.school.godbless.mattersoftheheart;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
public class Chat {
    private static final int SIZE = 2;
    private final List<User> chat = new ArrayList<>(SIZE);

    public void addUserToChat(User user) {
        if (chat.size() == SIZE) {
            log.warn("Нет места, попробуйте подключиться к другому чату");
        } else {
            chat.add(user);
        }
    }

    public void removeUserFromChat(User user) {
        chat.remove(user);
    }
}
