package faang.school.godbless.matters_of_the_heart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ChatManager {
    private List<Chat> chats;
    private UserList userList;

    public ChatManager(UserList userList) {
        this.chats = new ArrayList<>();
        this.userList = userList;
    }

    public synchronized void startChat(User user) {
        User waitForTheChatUser = userList.getWaitForChatUsers().poll();
        if (waitForTheChatUser == null) {
            Chat chat = new Chat(user);
            chats.add(chat);
            userList.setWaitForChatStatusToUser(user);
            user.joinChat(chat);
            log.info("User with name {} has joined the chat! But he/she is alone.", user.getName());
            waitForChat();
        } else {
            // Не совсем оптимально, так как поиск будет за O(n).
            // Можно написать какой-нибудь связный список, но решил не заморачиваться.
            Chat chat = chats.stream()
                    .filter(c -> c.getOwner().equals(waitForTheChatUser))
                    .findFirst()
                    .get();
            chat.setSecondUser(user);
            user.joinChat(chat);
            notify();
            log.info("User with name {} has joined the chat to the user with name {}", user.getName(), waitForTheChatUser.getName());
        }
    }

    public synchronized void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public synchronized void endChat(User user) {
        Chat currentChat = user.getCurrentChat();
        User aloneUser;
        if (currentChat.getOwner().equals(user)) {
            aloneUser = currentChat.getSecondUser();
        } else {
            aloneUser = currentChat.getOwner();
        }
        chats.remove(currentChat);
        user.leaveChat();
        aloneUser.leaveChat();
        log.info("User with name {} leave the chat!", user.getName());
        startChat(aloneUser);
    }
}