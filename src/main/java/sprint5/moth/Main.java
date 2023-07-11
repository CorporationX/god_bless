package sprint5.moth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final UserList USER_LIST = new UserList(Arrays.asList(
            new User("Robot1", false), new User("Robot2", true),
            new User("Robot3", false), new User("Robot4", false)
    ));
    private static final ChatManager CHAT_MANAGER = new ChatManager(USER_LIST);
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        List<User> users = USER_LIST.getAllUsers();


        for (User firstUser : users) {
            futures.add(CompletableFuture.runAsync(() -> CHAT_MANAGER.startChat(firstUser)));
            for (User secondUser : users) {
                if (firstUser != secondUser) {
                    futures.add(CompletableFuture.runAsync(() -> CHAT_MANAGER.waitForChat(secondUser)));
                }
            }
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Complete");
    }
}
