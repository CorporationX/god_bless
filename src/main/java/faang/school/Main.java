package faang.school;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        House house = new House("Big House", new HashMap<>());
        house.getAvailableRoles().put("Lord", 3);
        house.getAvailableRoles().put("Knight", 4);
        house.getAvailableRoles().put("Mage", 2);

        User user = new User("User1", house, "Lord");
        Thread joinThread1 = new Thread(user);
        joinThread1.start();
        Thread joinThread2 = new Thread(user);
        joinThread2.start();
        Thread joinThread3 = new Thread(user);
        joinThread3.start();
        Thread joinThread4 = new Thread(user);
        joinThread4.start();

        Thread joinThread5 = new Thread(() -> {
            try {
                user.leaveHouse();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        joinThread5.start();
    }
}
