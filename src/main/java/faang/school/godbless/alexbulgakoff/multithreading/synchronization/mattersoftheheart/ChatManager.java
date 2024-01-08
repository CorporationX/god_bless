package faang.school.godbless.alexbulgakoff.multithreading.synchronization.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class ChatManager {
    private final UserList userList;
    private final List<Chat> chatList;

    public ChatManager(UserList userList) {
        this.userList = userList;
        chatList = new ArrayList<>();
    }

    public synchronized Chat startChat(User user) throws InterruptedException {
        return null;
    }

    public synchronized void waitChat(Chat chat) throws InterruptedException {

    }

    public synchronized void endChat(Chat chat) {

    }

}
