package faang.school.godbless.BJS2_24418;

import java.util.ArrayList;
import java.util.List;


public class ChatManager {
    private UserList users;
    private List<Chat> chats = new ArrayList<>();

    public ChatManager(UserList users) {
        this.users = users;
    }

    public synchronized void startChat(User user) {
        while (users.getOnlineUsers(user).isEmpty()) {
            System.out.println("Nobody wants to talk");
            waitForChat(2000);
        }
        User secondUser = users.getOnlineUsers(user).stream()
                .filter(us -> !us.isChatting())
                .findFirst().get();
        Chat chat = new Chat(user, secondUser);
//        user.setChatting(true);
        user.setChat(chat);
        secondUser.setChat(chat);
        secondUser.setChatting(true);
        chat.startTalk();
        chats.add(chat);
    }

    public void waitForChat(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void endChat(User user) {
        Chat chat = user.getChat();
        chats.remove(chat);
        notifyAll();
        System.out.println("Chat between " + user.getName() + " and " + chat.getUser2().getName() + " ended");
        chat.getUser1().setChat(null);
        chat.getUser2().setChat(null);
    }

}
