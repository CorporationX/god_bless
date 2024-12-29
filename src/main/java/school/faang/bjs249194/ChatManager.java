package school.faang.bjs249194;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ChatManager {
    private final UserList userList = new UserList();
    private final ChatService chatService = new ChatService();

    public void startChat(User user) {
        log.info("Start chat {}", user);
        Chat chat = new Chat(user);
        chatService.addChat(new Chat(user));

        synchronized (userList) {
            chatService.connectToChat(chat);
        }
    }

    public void waitForChat(User user) {
        userList.addUserToSearch(user);

        chatService.connectAndWaitChat(user);
    }

    public void endChat(Chat chat) {
        chatService.removeChat(chat);
    }
}
