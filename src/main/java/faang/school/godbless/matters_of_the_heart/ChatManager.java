package faang.school.godbless.matters_of_the_heart;

import java.util.List;
import java.util.Random;

public class ChatManager {
    private UserList userList;
    private List<Chat> chats;
    private Random random = new Random();

    public ChatManager(UserList userList, List<Chat> chats) {
        this.userList = userList;
        this.chats = chats;
    }

    public void startChat(User user) throws InterruptedException {
        List<User> onlineUsers = userList.getOnlineUsers();
        if (onlineUsers.isEmpty()) {
            synchronized (userList) {
                userList.wait();
            }
        }

        User userTarget = onlineUsers.get(random.nextInt(onlineUsers.size()));

        boolean isUsersOnChat = isUserOnChat(user) || isUserOnChat(userTarget);
        if (isUsersOnChat) {
            System.out.printf("%s: cannot start chat between %s and %s: they are already on chat\n",
                    Thread.currentThread().getName(), user.getName(), userTarget.getName());
            return;
        }

        Chat chat = new Chat(user, userTarget);
        chats.add(chat);
        System.out.printf("%s: chats started between %s and %s\n",
                Thread.currentThread().getName(), chat.getUserOne(), chat.getUserTwo());
        Thread.sleep(3000);
        endChat(chat);
    }

    private void endChat(Chat chat) {
        synchronized (userList) {
            chats.remove(chat);
            System.out.printf("%s: chat end between %s and %s\n", Thread.currentThread().getName(), chat.getUserOne(), chat.getUserTwo());
            userList.notifyAll();
        }
    }

    private boolean isUserOnChat(User user) {
        return chats
                .stream()
                .anyMatch(chat -> user.equals(chat.getUserOne()) || user.equals(chat.getUserTwo()));
    }
}
