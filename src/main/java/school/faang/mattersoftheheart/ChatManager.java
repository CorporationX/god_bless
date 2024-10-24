package school.faang.mattersoftheheart;

import java.util.Optional;

public class ChatManager {
    private final UserList userList;

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized Optional<Chat> startChat(User user) {
        var onlineUsers = userList.getOnlineUsers();

        return onlineUsers.stream()
                .filter(u -> !u.equals(user))
                .findFirst()
                .map(availableUser -> {
                    Chat chat = new Chat(user, availableUser);
                    user.setLookingForChat(false);
                    availableUser.setLookingForChat(false);
                    chat.displayChatInfo();
                    return chat;
                });
    }

    public synchronized void endChat(Chat chat) {
        User user1 = chat.getUser1();
        User user2 = chat.getUser2();

        user1.setLookingForChat(true);
        user2.setLookingForChat(true);

        System.out.println("Chat ended between " + user1.getName() + " and " + user2.getName());
        notifyAll();
    }
}
