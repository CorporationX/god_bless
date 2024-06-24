package faang.school.godbless.synchronization.game_of_trones;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private  final static int POOL_SIZE = 2;
    public static void main(String[] args) throws InterruptedException {
        List<Role> roles = List.of(Role.LORD, Role.KNIGHT, Role.MAGE);
        House house = new House("Stark", roles);
        List<User> users = getUsers(house);
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        users.stream()
                .forEach(user -> {
                    executorService.submit(() -> {
                        try {
                            user.joinHouse();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    executorService.submit(user::leaveHouse);
                });
        executorService.shutdown();
    }

    private static final List<User> getUsers(House house) {
        return List.of(new User("User1", house, Role.LORD),
                new User("User2", house, Role.KNIGHT),
                new User("User3", house, Role.MAGE),
                new User("User4", house, Role.PRIEST),
                new User("User5", house, Role.LORD));
    }
}
