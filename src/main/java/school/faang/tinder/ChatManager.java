package school.faang.tinder;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ChatManager {

    private final UserList userList;

    public synchronized void startChat(User user) {
        while (userList.getUsersIsLookingForChat().isEmpty() || user.getChat() != null) {
            waitForChat();
        }

        userList.switchLookingForChat(user);
        User companion = userList.getUsersIsLookingForChat().iterator().next();
        new Chat(user, companion);
        userList.switchLookingForChat(companion);
        System.out.printf("%s and %s are chatting\n", user.getName(), companion.getName());
    }

    public void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        userList.switchLookingForChat(user);
        userList.switchLookingForChat(chat.getUser2());
        chat.removeChatFromUser();
        System.out.printf("%s is ending chat with %s\n", user.getName(), chat.getUser2().getName());
        notifyAll();
    }

}
