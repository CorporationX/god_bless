package school.faang.heartMatters;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        UserList users = new UserList();
        users.initializeRandomUsers();
        List<User> usersOnline = users.getOnlineUsers();
        ChatManager manager = new ChatManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (User user : usersOnline) {
            executor.submit(() -> manager.startChat(user));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Some threads couldn't complete their task.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
