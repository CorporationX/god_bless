package matters;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class ChatManager {
    private UserList userList;
    private List<Chat> chats;
    private Random random = new Random();

    public void startChat(User firstUser) throws InterruptedException {
        List<User> onlineUsers = userList.getOnlineUsers();
        if (onlineUsers.isEmpty()) {
            synchronized (userList) {
                userList.wait();
            }
        }
        User secondUser = onlineUsers.get(random.nextInt(onlineUsers.size()));
        if (firstUser.isChatting()||secondUser.isChatting()) {
            return;
        }
        Chat chat = new Chat(firstUser, secondUser);
        chats.add(chat);
        chat.getUsers().forEach(user -> {
            user.setChatting(true);
        });
        System.out.println("Chat between " + chat.getUsers().get(0).getName() + " " + chat.getUsers().get(1).getName() + " started ");
        Thread.sleep(10000);
        endChat(chat);

    }

    public void waitForChat(User user) {
        if (!user.isChatting()) {
            try {
               userList.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (userList) {
            chats.remove(chat);
            chat.getUsers().forEach(x -> x.setChatting(false));
            userList.notifyAll();
        }
    }

    public ChatManager(UserList userList, List<Chat> chats) {
        this.userList = userList;
        this.chats = chats;
    }
}
