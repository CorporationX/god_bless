package bjs2_37422;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Object lock = new Object();
        House house = new House("house1", List.of("role1", "role2"));
        List<User> users = List.of(
                new User("user1", lock),
                new User("user2", lock),
                new User("user3", lock),
                new User("user4", lock),
                new User("user5", lock),
                new User("user6", lock),
                new User("user7", lock)
        );

        users.forEach(user -> {
            Thread joinThread = new Thread(() -> {
                user.joinHouse(house);
            });
            joinThread.start();

            new Thread(() -> {
                try {
                    joinThread.join(1000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}
