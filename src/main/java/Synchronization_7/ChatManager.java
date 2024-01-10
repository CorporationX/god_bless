package Synchronization_7;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {

    private static List<Chat> chats = new ArrayList<>();

    public static void startChat(User user) {
        synchronized (chats) {
            List<User> userList;
            User userSecond;
            if (user.isSex().equals(Sex.FEMALE))
                userList = UserList.getMaleReadyContactUsers();
            else
                userList = UserList.getFemaleReadyContactUsers();
            userSecond = userList.get((int) (Math.random() * userList.size()));
            waitForChat(userSecond, userList);
            Chat chat = new Chat(user, userSecond);
            user.setChatting(true);
            userSecond.setChatting(true);
            System.out.println("Chat with " + chat.getUserFemale().getName() + " and " + chat.getUserMale().getName() + " start");
        }
    }

    public static void waitForChat(User user, List<User> userList) {
        if (user.isChatting() || userList.isEmpty()) {
            try {
                System.out.println(user.getName() + " now is chatting. Please wait");
                chats.wait();
            } catch (InterruptedException e) {
                System.out.println("Now nobody ready chatting");
            }
        }

    }

    public static void endChat(User user) {
        synchronized (chats) {
            if ((user.isChatting())) {
                Chat chat = giveChat(user);
                System.out.println("Chat with " + chat.getUserFemale().getName() + " and " + chat.getUserMale().getName() + " remove");
                chat.getUserFemale().setChatting(false);
                chat.getUserMale().setChatting(false);
                chats.remove(chat);
                chats.notifyAll();
            }
        }
    }

    private static Chat giveChat(User user) {
        Chat checkChat = null;
        for (Chat chat : chats) {
            if (user.isSex().equals(Sex.MALE)) {
                if (chat.getUserMale().getName().equals(user.getName()))
                    checkChat = chat;
            } else {
                if (chat.getUserFemale().getName().equals(user.getName()))
                    checkChat = chat;
            }
        }
        return checkChat;
    }

    public static void addChat(Chat chat) {
        synchronized (chats) {
            chats.add(chat);
        }
    }

}
