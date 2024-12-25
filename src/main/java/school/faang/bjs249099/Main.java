package school.faang.bjs249099;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        House house = new House("Kremlin", Arrays.asList("role1", "role2"));
        User parvin = new User("Parvin");
        User narmin = new User("Narmin");
        User putin = new User("Alex");

        Thread t1 = new Thread(() -> {
            parvin.joinHouse(house, "President");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            parvin.leaveHouse();
        });

        Thread t2 = new Thread(() -> {
            narmin.joinHouse(house, "Premier Minister");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            narmin.leaveHouse();
        });

        Thread t3 = new Thread(() -> {
            putin.joinHouse(house, "Parliament member");
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            putin.leaveHouse();
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
