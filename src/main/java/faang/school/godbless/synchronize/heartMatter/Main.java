package faang.school.godbless.synchronize.heartMatter;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            users.add(new User("User" + i, new Random().nextBoolean(), new Random().nextBoolean()));
        }

        UserList userList = new UserList(users);

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(chatManager::startChat);

        executorService.shutdown();
    }
}
