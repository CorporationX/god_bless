package derschrank.sprint03.task13.bjstwo_49141;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final boolean FLAG_ACTIVE_USER = true;
    private static final int SIZE_OF_THREADPOOL = 15;

    public static void main(String[] args) {
        UserList users = new UserList();
        users.addUser(new User("Ivan", FLAG_ACTIVE_USER));
        users.addUser(new User("Petr", FLAG_ACTIVE_USER));
        users.addUser(new User("Sidr", FLAG_ACTIVE_USER));
        users.addUser(new User("Fedr", FLAG_ACTIVE_USER));
        users.addUser(new User("Mike", FLAG_ACTIVE_USER));
        users.addUser(new User("Alex", FLAG_ACTIVE_USER));
        users.addUser(new User("Alexander", FLAG_ACTIVE_USER));
        users.addUser(new User("Olga", FLAG_ACTIVE_USER));
        users.addUser(new User("Julia", FLAG_ACTIVE_USER));
        users.addUser(new User("Polina", FLAG_ACTIVE_USER));
        users.addUser(new User("Elena", FLAG_ACTIVE_USER));
        users.addUser(new User("Chupokabra"));

        ChatManagerInterface manager = new ChatManager(users);

        ExecutorService executor = Executors.newFixedThreadPool(SIZE_OF_THREADPOOL);
        for (User user : users.getUsers()) {
            if (user.isActiveLookingForChat()) {
                executor.execute(() -> manager.startChat(user));
            }
        }

        executor.shutdown();


    }
}
