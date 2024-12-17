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

            userList.removeUser(user);
            userList.removeUser(secondUser);

            System.out.println("Found second user: " + secondUser);

            Chat chat = new Chat(user, secondUser);
            chat.startChat();

            System.out.println("Users are chatting!");
            Thread.sleep(5000);

            endChat(chat);
        }
    }

    public void endChat(Chat chat) throws InterruptedException {
        chat.endChat();

        Thread.sleep(3000);

        userList.addUser(chat.getFirstUserToChat());
        userList.addUser(chat.getSecondUserToChat());
    }
}
