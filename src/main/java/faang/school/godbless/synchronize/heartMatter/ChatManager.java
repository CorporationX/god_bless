package faang.school.godbless.synchronize.heartMatter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatManager {
    private UserList userList;
    private List<User> onlineWantToChatUsers;
    private List<Chat> chats = new ArrayList<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized void startChat() {
        try {
            onlineWantToChatUsers = userList.getWantToChatUsers();

            if (!onlineWantToChatUsers.isEmpty()) {
                while (onlineWantToChatUsers.size() >= 2) {
                    User user1 = onlineWantToChatUsers.remove(0);
                    User user2 = onlineWantToChatUsers.remove(1);
                    Chat chat = new Chat(user1, user2);
                    chats.add(chat);
                    System.out.println(user1.getName() + " chatting with " + user2.getName());
                    chat.chattingStart();
                    endChat(chat);
                }
            } else {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void endChat(Chat chat) {
        System.out.println("Chat ended");
        chats.remove(chat);
        notifyAll();
    }
}
