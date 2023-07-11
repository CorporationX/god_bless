package matters_of_the_heart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatManager {
    private UserList userList;
    private Set<Chat> chatList;
    private Lock lock = new ReentrantLock();

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chatList = new HashSet<>();
    }

    public synchronized void startChat(User user) {
        lock.lock();
        try {
            List<User> eligibleUsers = userList.getUsersEligibleToStartChat(user);
            while (eligibleUsers.isEmpty() || chatList.contains(user.getChat())) {
                waitForChat();
                eligibleUsers = userList.getUsersEligibleToStartChat(user);
            }
            User otherUser = eligibleUsers.get(0);
            Chat chat = new Chat(user, otherUser);
            chatList.add(chat);
            user.setChat(chat);
            otherUser.setChat(chat);
            System.out.println(user.getName() + " start chat with " + otherUser.getName());
        } finally {
            lock.unlock();
        }
    }

    private void waitForChat(){
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        chatList.remove(chat);
        User user1 = chat.getUser1();
        User user2 = chat.getUser2();
        user1.resetChat();
        user2.resetChat();
        notifyAll();
        System.out.println(user1.getName() + " end chat with " + user2.getName());
    }
}
