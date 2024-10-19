package school.faang.mattersoftheheart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_SIZE_POOL = 8;
    private static final int TIME_TO_WORK = 1000;
    private static final int MAX_TIME_WORK = 100;

    public static void main(String[] args) {
        UserList userList = new UserList();
        userList.addUser(new User("Alex", true, true));
        userList.addUser(new User("Ivan", false, true));
        userList.addUser(new User("Sergey", true, true));
        userList.addUser(new User("Anna", true, true));
        userList.addUser(new User("Darya", true, true));
        userList.addUser(new User("Olya", true, true));

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_SIZE_POOL);

        for (User user : chatManager.getUsers().getOnlineUsers()) {
            executor.submit(() -> {
                Chat chat = chatManager.startChat(user);

                try {
                    Thread.sleep(TIME_TO_WORK);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (chat != null) {
                    chatManager.endChat(chat);
                }
            });
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(MAX_TIME_WORK, TimeUnit.SECONDS)) {
                System.out.println("Программа завершена");
            } else {
                executor.shutdownNow();
                System.out.println("Программа завершена принудительно");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}