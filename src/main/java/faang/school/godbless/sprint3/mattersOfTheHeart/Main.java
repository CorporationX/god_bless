package faang.school.godbless.sprint3.mattersOfTheHeart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int MAX_USERS = 100;
    private static final Random random = new Random();
    private static ChatManager chatManager;
    private static ExecutorService executor;
    private static UserList userList;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        IntStream.rangeClosed(1, 100)
                .forEach(id -> users.add(new User(id, String.format("User %d", id), random.nextBoolean())));
        userList = new UserList(users);
        chatManager = new ChatManager(userList);
        executor = Executors.newFixedThreadPool(MAX_USERS);
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    startChatManager();
                    userList.changeStatus(user -> !chatManager.getUsersAtChats().contains(user));
                });
        executor.shutdown();
    }

    public static void startChatManager() {
        userList.getOnlineUsers().forEach(user -> executor.execute(() -> {
            Chat chat = null;
            try {
                chat = chatManager.startChat(user);
                Thread.sleep(random.nextInt(1, 11) * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (chat != null) {
                chatManager.endChat(chat);
            }
        }));
    }
}
