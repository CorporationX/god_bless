package bjs2_35748;

import lombok.AllArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
public class ChatManager {
    private static final int TIME_T0_CHAT = 5000;

    private UserList userList;

    public void simulateChat(User user) throws InterruptedException {
        Chat chat = startChat(user);
        Thread.sleep(TIME_T0_CHAT);
        endChat(chat);
    }

    private synchronized Chat startChat(User user) throws InterruptedException {
        if (!user.isLookingForChat()) {
            throw new IllegalArgumentException("User not looking for chat");
        }

        Queue<User> usersWantingToChat = userList.getOnlineUsersExcludingUser(user);
        if (usersWantingToChat.isEmpty()) {
            waitForChat();
            usersWantingToChat = userList.getOnlineUsersExcludingUser(user);
        }

        User chatter = usersWantingToChat.poll();
        Chat chat = new Chat(user, chatter);

        user.setLookingForChat(false);
        chatter.setLookingForChat(false);

        System.out.printf("Chat %s started\n", chat);
        return chat;
    }

    private synchronized void waitForChat() throws InterruptedException {
        System.out.println("No available users to chat with. Switching to a waiting mode");
        wait();
    }

    private synchronized void endChat(Chat chat) {
        User firstUser = chat.getUser1();
        User secondUser = chat.getUser2();

        System.out.printf("Chat %s ended\n", chat);

        chat.setUser1(null);
        chat.setUser2(null);

        firstUser.setLookingForChat(true);
        secondUser.setLookingForChat(true);

        notifyAll();
    }
}
