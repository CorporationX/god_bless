package school.faang.sprint_3.task_49139;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class ChatManager {
    private static final int MAX_WAIT_TIME = 1000;
    private final UserList userList;
    private final List<Chat> chats = new ArrayList<>();

    public synchronized void startChat(User user) {
        List<User> usersReadyToChat = userList.getUsersReadyToChatWith(user);
        while (usersReadyToChat.isEmpty()) {
            try {
                wait(MAX_WAIT_TIME);
            } catch (InterruptedException e) {
                System.out.println("Waiting interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
        User otherUser = usersReadyToChat.get(0);
        Chat chat = new Chat(user, otherUser);
        chats.add(chat);
        user.setChat(chat);
        otherUser.setChat(chat);
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        chats.remove(chat);
        User firstUser = chat.getFirstUser();
        User secondUser = chat.getSecondUser();
        System.out.println("Ending chat " + firstUser + " and " + secondUser);
        firstUser.resetChat();
        secondUser.resetChat();
        notifyAll();
    }
}
