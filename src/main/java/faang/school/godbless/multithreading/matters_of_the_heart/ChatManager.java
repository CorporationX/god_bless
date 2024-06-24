package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatManager {

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    private UserList userList;

    private List<Chat> chats = new ArrayList<>();

    public void startChat(User user) throws InterruptedException {

        synchronized (this) {

            Optional<User> activeUsers = userList.getOnlineUsers().stream()
                    .filter(u -> u.hashCode() != user.hashCode() && user.isCommunication())
                    .findFirst();


            if (activeUsers.isPresent()) {
                user.setCommunication(false);
                activeUsers.get().setCommunication(false);

                Chat chat = new Chat(user, activeUsers.get(), true);
                chats.add(chat);
                chat.communication(this);
            } else {
                wait(user);
            }
        }

    }

    public void wait(User user) throws InterruptedException {
        synchronized (user) {
            user.wait();
        }

    }

    public void endChat(Chat chat) {
        synchronized (chat) {
            chat.fUser.setCommunication(true);
            chat.sUser.setCommunication(true);
            chats.remove(chat);

            notifyAll();
        }
    }
}
