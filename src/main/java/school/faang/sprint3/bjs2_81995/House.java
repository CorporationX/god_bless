package school.faang.sprint3.bjs2_81995;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class House {
    private static final int THREAD_BATCH = 5;

    private List<String> roles = new ArrayList<>();

    House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_BATCH);
        List<String> roles = List.of("Role 1", "Role 2");
        House house = new House(roles);
        List<User> users = List.of(
                new User("User 1"), new User("User 2"), new User("User 3"), new User("User 4")
        );
        users.forEach(user -> executor.execute(() -> user.joinHouse(house)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
