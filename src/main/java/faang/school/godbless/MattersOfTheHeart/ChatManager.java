package faang.school.godbless.MattersOfTheHeart;

import lombok.Getter;

@Getter
public class ChatManager {
    private final ChatService chats = new ChatService();
    private final UserList users;
    private final User currentUser;

    public ChatManager(UserList users, User currentUser) {
        this.users = users;
        this.currentUser = currentUser;
        users.removeUser(currentUser);
    }

    public void startChat() throws InterruptedException {
        final UserList mutualUsers = currentUser.getMutualUsers();
        synchronized (mutualUsers) {
            if (mutualUsers.isEmpty()) {
                System.out.printf("%s has no users to chat\n", currentUser.getName());
                mutualUsers.wait();
            }
            synchronized (chats) {
                mutualUsers.forEach(user -> {
                    chats.addChat(new Chat(currentUser, user));
                    System.out.printf("%s and %s started a chat\n", currentUser.getName(), user.getName());
                });
                chats.notifyAll();
            }
        }
    }

    public void waitForChat() throws InterruptedException {
        synchronized (chats) {
            if (chats.isEmpty()) {
                chats.wait();
            }
            chats.runChats();
            chats.removeBadChats();
        }
    }
}