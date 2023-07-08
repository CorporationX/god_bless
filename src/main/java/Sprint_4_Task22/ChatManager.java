package Sprint_4_Task22;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;
@Data
public class ChatManager {
    private UserList userList;
    private Set<Chat> chats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chats = new HashSet<>();
    }

    public synchronized void startChat(User user) {
        while (userList.getOnlineUsers(user).isEmpty() || chats.contains(user.getChat())) {
            waitForChat();
        }
        User chatUser = userList.getOnlineUsers(user).get(0);
        Chat chat = new Chat(user, chatUser);
        chats.add(chat);
        user.setChattingTrue(chat);
        chatUser.setChattingTrue(chat);
        System.out.println(user.getName() + " и " + chatUser.getName() + " начали чат");
    }
    @SneakyThrows
    public void waitForChat() {
        wait();
    }
    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        chats.remove(chat);
        User user1 = chat.userOne;
        User user2 = chat.userTwo;
        user1.removeChatting();
        user2.removeChatting();
        notifyAll();
        System.out.println(user1.getName() + " и " + user2.getName() + " закончили чат");
    }
}
