package matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private UserList userList;
    private List<Chat> chatList;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chatList = new ArrayList<>();
    }

    public synchronized void startChat(User user) {
        while (userList.getUsersEligibleToStartChat(user).isEmpty() || chatList.contains(user.getChat())) {
            waitForChat();
        }
        User otherUser = userList.getUsersEligibleToStartChat(user).get(0);
        Chat chat = new Chat(user, otherUser);
        chatList.add(chat);
        user.setChat(chat);
        otherUser.setChat(chat);
        System.out.println(user.getName() + " start chat with " + otherUser.getName());
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
