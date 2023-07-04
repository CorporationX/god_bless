package faang.school.godbless.synchronizationWaitNotify.matterOfTheHeart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMBER_THREADS = 50;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);

        List<User> users = new ArrayList<>(IntStream.rangeClosed(1, 50).boxed()
                .map(number -> new User("user №" + number))
                .toList());

        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(userList);

        for (User user : users) {
            executorService.submit(() -> {
                chatManager.startChat(user);

                //общение
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                //удаляем чат, если он еще не удален
                chatManager.getChatByUser(user).ifPresent(chatManager::endChat);
            });
        }

        executorService.shutdown();
    }
}
