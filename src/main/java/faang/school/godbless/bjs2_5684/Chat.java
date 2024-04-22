package faang.school.godbless.bjs2_5684;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
public class Chat {

    private static final int CHAT_SIZE = 2;

    private List<User> chatUsers = new ArrayList<>(CHAT_SIZE);

    public boolean addUserToChat(User user) {
        if (chatUsers.size() == CHAT_SIZE) {
            log.warn("Chat busy. Try another chat");
            return false;
        } else {
            chatUsers.add(user);
            return true;
        }
    }

    public void removeUserFromChat(User user) {
        chatUsers.remove(user);
    }
}
