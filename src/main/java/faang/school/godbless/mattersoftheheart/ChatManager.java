package faang.school.godbless.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {

    private List<Chat> chats = new ArrayList<>();
    private UserList userList = new UserList();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }


    public void startChat(User user){
        synchronized (chats){
            System.out.println(user.getName() + " wants to chat");
            user.setWantsToChat(true);
            List<User> onlineUsers = userList.getOnlineUsers(user);
            List<User> wantToChat = onlineUsers.stream()
                    .filter((User::wantsToChat))
                    .toList();
            if (wantToChat.isEmpty()){
                System.out.println("Nobody is online or nobody wants to chat right now, wait ...");
                chats.notifyAll();
                waitForChat(user);
            }
            new Chat(user, wantToChat.get(0));
            System.out.println("The chat is started with " + user.getName() + " and " + wantToChat.get(0).getName());
            try {
                System.out.println("Chat is ongoing for 10 seconds");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //called when user wants to chat
        //should find one more user also wants to start chat and create a new chat,
        // if there is no more users wishing to chat, it should wait for another user to get free and wishing to chat
    }

    private void waitForChat(User user){
            System.out.println("Checking if any chats are available to join");
            List<Chat> chatsToJoin = chats.stream()
                    .filter((chat -> !chat.isFull()))
                    .toList();
            if (chatsToJoin.isEmpty()){
                System.out.println("No chats are available, waiting...");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        }
        //В методе waitForChat() проверьте, есть ли уже чат, в котором участвует пользователь.
        // Если такой чат не найден, вызовите метод wait() и ждите, пока чат не будет создан.
    }

    public void endChat(User user){
        synchronized (chats){
            Chat chat = chats.stream()
                    .filter(c -> c.getUser1() == user & c.getUser2() == user)
                            .toList().get(0);
            chat.leaveChat(user);
            chats.notifyAll();
        }
    }
}
