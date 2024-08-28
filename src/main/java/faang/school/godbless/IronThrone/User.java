package faang.school.godbless.IronThrone;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

@Setter
@Getter
@Slf4j
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        House house = new House();
        house.setAvailableRoles(3);

        // Создаем пользователей
        User user1 = new User("John");
        user1.setHouse(house);
        User user2 = new User("Alice");
        user2.setHouse(house);
        User user3 = new User("Bob");
        user3.setHouse(house);
        User user1_1 = new User("John2");
        user1_1.setHouse(house);
        User user2_1 = new User("Alice2");
        user2_1.setHouse(house);
        User user3_1 = new User("Bob2");
        user3_1.setHouse(house);
        User user1_1_ = new User("John3");
        user1_1_.setHouse(house);
        User user2_1_ = new User("Alice3");
        user2_1_.setHouse(house);
        User user3_1_ = new User("Bob3");
        user3_1_.setHouse(house);


        Thread thread1 = new Thread(() -> {
            user1.joinHouse();
            user1_1.joinHouse();
        });
        Thread thread2 = new Thread(() -> {
            user2.joinHouse();
            user2_1.joinHouse();
        });
        Thread thread3 = new Thread(() -> {
            user3.joinHouse();
            user3_1.joinHouse();
        });

        Thread thread1_ = new Thread(user2_1_::joinHouse);
        Thread thread2_ = new Thread(user1_1_::joinHouse);
        Thread thread3_ = new Thread(user3_1_::joinHouse);

        thread1.start();
        thread2.start();
        thread3.start();
        thread1_.start();
        thread2_.start();
        thread3_.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread1_.join();
            thread2_.join();
            thread3_.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public void joinHouse() {
        house.addRole(this);
        leaveHouse();
    }

    public void leaveHouse() {
        house.removeRole(this);
    }
}
