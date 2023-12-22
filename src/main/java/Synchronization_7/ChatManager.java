package Synchronization_7;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {

    private static List<Chat> chats = new ArrayList<>();

    public static void startChat(User user) {
        synchronized (chats) {
            List<User> userList;
            if (user.isSex() == true)
                userList = UserList.getMaleReadyContactUsers();
            else
                userList = UserList.getFemaleReadyContactUsers();
            if ((userList.isEmpty()) || (waitForChat(user))) {
                try {
                    chats.wait();
                } catch (InterruptedException e) {
                    System.out.println("Now nobody ready chatting");
                }
            }
            Chat chat = new Chat(user, userList.get((int) (Math.random() * userList.size())));
            System.out.println("Chat with " + chat.getUserFemale().getName() + " and " + chat.getUserMale().getName() + " start");
        }
    }

    public static boolean waitForChat(User user) {
        if (giveChat(user) != null)
            return true;
        else
            return false;
    }

    public static void endChat(User user) {
        synchronized (chats) {
            Chat chat;
            if (waitForChat(user)) {
                chat = giveChat(user);
                chat.personalContact();
                System.out.println("Chat with " + chat.getUserFemale().getName() + " and " + chat.getUserMale().getName() + " remove");
                chats.remove(chat);
                chats.notifyAll();
            }
        }
    }

    private static Chat giveChat(User user) {
        Chat checkChat = null;
        for (Chat chat : chats) {
            if (chat.getUserFemale().getName().equals(user.getName()) || (chat.getUserMale().getName().equals(user.getName())))
                checkChat = chat;
        }
        return checkChat;
    }

    public static void addChat(Chat chat) {
        if ((!waitForChat(chat.getUserFemale())) || (!waitForChat(chat.getUserMale())))
            chats.add(chat);
    }

}
