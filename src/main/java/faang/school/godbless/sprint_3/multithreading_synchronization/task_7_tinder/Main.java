package faang.school.godbless.sprint_3.multithreading_synchronization.task_7_tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int COUNT_USERS = 20;
    public static final int COUNT_THREADS = 3;
    public static final int TIME_OUT = 30;

    public static void main(String[] args) throws InterruptedException {
        UserList userList = createUserList();
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

        // для теста списка чатов
        List<Chat> chats = new ArrayList<>();
        User user1 = new User("user_40");
        user1.online();
        user1.setStatus(Status.ONLINE);
        User user2 = new User("user_41");
        user2.online();
        user2.setStatus(Status.ONLINE);

        userList.addUser(user1);
        userList.addUser(user2);

        chats.add(new Chat(user1, user2));


        ChatManager manager = new ChatManager(userList, chats);

        for (User user : userList.users) {
            executor.execute(() -> {
                try {
                    manager.startChat(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS);

        // Приложение почему-то продолжает работать
        manager.setActiveOff();
        System.exit(0);
    }

    // Создание UserList с пользователями
    private static UserList createUserList() {
        UserList users = new UserList();
        for (int i = 1; i <= COUNT_USERS; i++) {
            User user = createUser("user_" + i);
            users.addUser(user);
        }
        return users;
    }

    // создание пользователя со случайными настройками
    private static User createUser(String name) {
        User user = new User(name);
        int chance = (int) (Math.random() * 10);

        // 90% что пользователь будет в онлайне
        if (chance < 9) {
            user.online();
            // 70% что пользователь хочет общаться
            if (chance < 7) {
                user.setStatus(Status.LOOKING_FOR_CHAT);
            } else {
                user.setStatus(Status.ONLINE);
            }
        }
        return user;
    }


}
