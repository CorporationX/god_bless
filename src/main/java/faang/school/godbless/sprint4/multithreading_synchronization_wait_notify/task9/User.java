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

    private final House house;

    private Role role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    @SneakyThrows
    public void joinHouse() {
        synchronized (house) {
            System.out.println(Thread.currentThread().getName() + " " + house.checkRole());
            while (house.checkRole().isEmpty()) {
                System.out.println(name + " ожидает свободную роль");
                house.wait();
            }

            role = house.checkRole().get(new Random().nextInt(house.checkRole().size()));
            house.addRole(role);
            System.out.println(name + " присоеденился к " + house.getNameHouse() + " в роли " + role);
        }
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " покинул " + house.getNameHouse());
            house.removeRole(role);
            role = null;
            house.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        House house = new House("Дом старков", 1, 0, 1);
        User user1 = new User("Эддард Старк", house);
        User user2 = new User("Роб Старк", house);
        User user3 = new User("Джон Сноу", house);
        User user4 = new User("Бран", house);
        User user5 = new User("Арья", house);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(user1::joinHouse);
        executor.execute(user2::joinHouse);
        executor.execute(user3::joinHouse);
        executor.execute(user5::joinHouse);
        executor.execute(user1::leaveHouse);
        executor.execute(user4::joinHouse);

        executor.shutdown();

        while (!executor.awaitTermination(500, TimeUnit.MICROSECONDS)) {
        }

        System.out.println("Done!");
    }
}
