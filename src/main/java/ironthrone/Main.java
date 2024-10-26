package ironthrone;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        House house = new House(Arrays.asList("role1", "role3"));

        User user1 = new User("user1", house, "role1");
        User user2 = new User("user2", house, "role1");
        User user3 = new User("user3", house, "role3");

        Thread thread1 = new Thread(() -> {
            user1.joinHouse();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Что-то пошло не так при вызове метода wait().");
            }
            user1.leaveHouse();
        });
        Thread thread2 = new Thread(user2::joinHouse);
        Thread thread3 = new Thread(user3::joinHouse);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
