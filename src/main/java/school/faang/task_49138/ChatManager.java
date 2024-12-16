package school.faang.task_49138;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChatManager {
    private UserList userList;

    public void startChat(User user) throws InterruptedException {
        while (true) {
            if (!userList.getOnlineUsers().contains(user)) {
                throw new IllegalArgumentException("User don`t want to message!");
            }

            User secondUser = userList.getRandomUserWantsChat(user);
            System.out.println("Found second user: " + secondUser);

            if (secondUser == null) {
                waitForChat();
            } else {
                Chat chat = new Chat(user, secondUser);
                chat.startChat();

                userList.removeUser(user);
                userList.removeUser(secondUser);

                System.out.println("Users are chatting!");
                Thread.sleep(1000);
                endChat(chat, user, secondUser);
            }
        }
    }

    public void waitForChat() throws InterruptedException {
        if (userList.getOnlineUsers().size() < 2) {
            System.out.println("Waiting for user that wants to chat!");
            wait();
        }
    }

    public void endChat(Chat chat, User user, User secondUser) throws InterruptedException {
        chat.endChat();

        Thread.sleep(3000);

        userList.addUser(user);
        userList.addUser(secondUser);
    }
}
