package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        User john = new User("John", true, true);
        User ann = new User("Ann", true, true);
        User toma = new User("Toma", true, true);

        UserList users = new UserList(List.of(john, ann, toma));

        ChatManager chatManager = new ChatManager(users);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(() -> {
            try {
                chatManager.startChat(new User("Bob", true, true));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                chatManager.startChat(ann);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                chatManager.startChat(toma);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();

    }
}
