package faang.school.godbless.matters_of_the_heart;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class ChatManager {
    private final List<Chat> chats = new ArrayList<>();
    private UserList users;

    public ChatManager(UserList users) {
        this.users = users;
    }



    public void startChat(User user) {
        synchronized (chats) {
            users.deleteUser(user);
            List<User> onlineUsers = users.getOnlineUser();
            if(users.doesAnyWantChat()) {
                for(User user1 : onlineUsers) {
                    Chat chat = new Chat(user, user1);
                    synchronized (users) {
                        user.setPrepareToChat(false);
                        user1.setPrepareToChat(false);
                        users.deleteUser(user);
                        users.deleteUser(user1);
                        users.notifyAll();
                    }
                    chats.add(chat);
                    chat.chatting();
                    break;
                }
            } else {
                try {
                    chats.wait(5000);
                    System.out.println("While no one is ready to chat with " + user.getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @SneakyThrows
    public synchronized void waitForChat(User user) {
        boolean isInChats = chats.stream().
                anyMatch(chat -> chat.getUser2() == user || chat.getUser1() == user);
        if(!isInChats) {
            System.out.println(user.getName() + " - is not in the chat list!");
        }
    }

    public void endChat(Chat chat) {
        synchronized (chats) {
            chats.remove(chat);
            synchronized (users) {
                users.addUser(chat.getUser1());
                users.addUser(chat.getUser2());
                users.notifyAll();
            }
            System.out.println("Chat of " + chat.getUser1().getName() + " and " + chat.getUser2().getName() + " has been deleted");
            chats.notifyAll();
        }
    }
}
