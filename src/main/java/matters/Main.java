package matters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList(
                List.of(new User("User1", true),
                        new User("User2", false),
                        new User("User3", true),
                        new User("User4", false),
                        new User("User5", true),
                        new User("User6", false),
                        new User("User7", true))
        );

        List<User> anotherUsers =
                List.of(new User("User8", true),
                        new User("User9", true),
                        new User("User10", true),
                        new User("User11", true),
                        new User("User12", true),
                        new User("User13", true),
                        new User("User14", true));

        ChatManager chatManager = new ChatManager(userList, new ArrayList<>());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (User user : anotherUsers) {
            executorService.execute(() ->
            {
                try {
                    chatManager.startChat(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
    }
}
