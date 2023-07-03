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
                    chats.add(chat);
                    chat.chatting();
                    break;
                }
            } else {
                try {
                    System.out.println("while no one is ready to chat");
                    chats.wait();
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
            //wait();
        }
    }

    public void endChat(Chat chat) {
        synchronized (chats) {
            chats.remove(chat);
            System.out.println("Chat of " + chat.getUser1().getName() + " and " + chat.getUser2().getName() + " has been deleted");
            chats.notifyAll();

            //if(!chats.isEmpty()) {
                //List<Chat> chatOf = chats.stream().filter(chat1 -> chat1.getUser1().equals(user1) && chat1.getUser2().equals(user2)).toList();
                //Chat usersChat = chatOf.get(0);
                //chats.remove(usersChat);
                //chats.notifyAll();
                //System.out.println(user1.getName() + " deleted chat with " + user2.getName());
            //} else {
                //System.out.println("this chat does not exist");
            //}
        }
    }
}
