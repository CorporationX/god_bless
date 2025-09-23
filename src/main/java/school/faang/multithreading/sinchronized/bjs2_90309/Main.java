package school.faang.multithreading.sinchronized.bjs2_90309;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        House firstHouse = new House("Первый дом");

        HouseAction houseAction = (user, house, role) -> {
            user.joinHouse(house, role);
            Thread.sleep(2000);
        };

        List<Thread> threads = createThreadsForHouseActions(firstHouse, houseAction,
                new User("первый рыцарь"), Role.KNIGHT,
                new User("Tom"), Role.KNIGHT,
                new User("прирожденный маг"), Role.MAGE,
                new User("маг2"), Role.MAGE,
                new User("Lord"), Role.LORD,
                new User("Лорд"), Role.LORD
        );
        threads.forEach(Thread::start);
    }

    private static List<Thread> createThreadsForHouseActions(House house,
                                                             HouseAction action,
                                                             Object... userRolePairs) {
        return IntStream.range(0, userRolePairs.length / 2)
                .mapToObj(i -> {
                    User user = (User) userRolePairs[i * 2];
                    Role role = (Role) userRolePairs[i * 2 + 1];
                    return createThreadWithHouseAction(user, house, role, action);
                })
                .toList();
    }

    private static Thread createThreadWithHouseAction(User user, House house, Role role, HouseAction action) {
        return new Thread(() -> {
            try {
                action.execute(user, house, role);
            } catch (InterruptedException e) {
                handleInterruptedException(user, e);
            } finally {
                user.leaveHouse();
            }
        });
    }

    private static void handleInterruptedException(User user, InterruptedException e) {
        System.err.println("Ошибка в потоке для пользователя " + user.getName() + ": " + e.getMessage());
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }
}