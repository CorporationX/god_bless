package school.faang.godbless.bjs2_37506;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Tinder {
    private static final int SLEEP_TIME = 7000;

    public static void main(String[] args) {
        UserList userList = new UserList(List.of(
                new User("initial1", true, true),
                new User("initial2", true, true),
                new User("initial3", true, true)
        ));
        ChatManager chatManager = new ChatManager(userList);
        List<Chat> chats = new ArrayList<>();
        Runnable createChats = () -> {
            while (true) {
                try {
                    synchronized (chats) {
                        Chat newChat = chatManager.startChat();
                        chats.add(newChat);
                    }
                } catch (InterruptedException e) {
                    log.warn("Chat starting thread is interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable addUsers = () -> {
            while (true) {
                try {
                    Thread.sleep(SLEEP_TIME);
                    User user = new User(UUID.randomUUID().toString(), true, true);
                    chatManager.addAvailableUser(user);
                } catch (InterruptedException e) {
                    log.warn("Adding users thread is interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable deleteChats = () -> {
            while (true) {
                try {
                    Thread.sleep(SLEEP_TIME);
                    synchronized (chats) {
                        Chat chat = chats.remove(ThreadLocalRandom.current().nextInt(0, chats.size()));
                        chatManager.endChat(chat);
                    }
                } catch (InterruptedException e) {
                    log.warn("Deleting chats thread is interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        };

        ExecutorService poolForChatCreation = Executors.newSingleThreadExecutor();
        poolForChatCreation.submit(createChats);
        ExecutorService poolForAddingUsers = Executors.newSingleThreadExecutor();
        poolForAddingUsers.submit(addUsers);
        ExecutorService poolForDeletingChats = Executors.newSingleThreadExecutor();
        poolForDeletingChats.submit(deleteChats);
    }
}
