package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        UserList users = new UserList(List.of(new User("John", true, true),
                new User("Ann", true, true),
                new User("Toma", false, true)));


        ChatManager chatManager = new ChatManager(users);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(() -> chatManager.startChat(new User("Bob", true, true)));

        executor.shutdown();

    }
}
