package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Setter
@Getter
public class User {

    private String name;

    private House house;

    private Role role;

    public User(String name) {
        this.name = name;
    }

    @SneakyThrows
    public void joinHouse(House house) {
        synchronized (house) {
            System.out.println(house.checkRole());
            while (house.checkRole().isEmpty()) {
                System.out.println(name + " ожидает свободную роль");
                house.wait();
            }

            role = house.checkRole().get(new Random().nextInt(house.checkRole().size()));
            house.addRole(role);
            System.out.println(name + " присоеденился к " + house.getNameHouse() + " в роли " + role);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            house.removeRole(role);
            role = null;
            System.out.println(name + " покинул " + house.getNameHouse());
            house.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        House house = new House("Дом старков", 1, 0, 1);
        User user1 = new User("Эддард Старк");
        User user2 = new User("Роб Старк");
        User user3 = new User("Джон Сноу");
        User user4 = new User("Бран");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> user1.joinHouse(house));
        executor.execute(() -> user2.joinHouse(house));
        executor.execute(() -> user3.joinHouse(house));
        executor.execute(() -> user1.leaveHouse(house));
        executor.execute(() -> user2.leaveHouse(house));
        executor.execute(() -> user4.joinHouse(house));

        executor.shutdown();

        while (!executor.awaitTermination(500, TimeUnit.MICROSECONDS)) {
        }

        System.out.println("Done!");
    }
}
