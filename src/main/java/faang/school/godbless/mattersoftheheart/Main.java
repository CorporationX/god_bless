package faang.school.godbless.mattersoftheheart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREAD = 10;
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREAD);

        userList.getUsers().forEach((user) ->{
            executorService.submit(() -> {
                chatManager.startChat(user);
                chatManager.endChat(user);
            });
        });
        executorService.shutdown();
    }
}
