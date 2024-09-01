package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> roles = new HashMap<>();
        roles.put("Лорд", 1);
        roles.put("Рыцарь", 2);
        roles.put("Маг", 1);

        House starkHouse = new House("Старк", roles);

        User user1 = new User("Джон");
        User user2 = new User("Арья");
        User user3 = new User("Санса");

        new Thread(() -> {
            try {
                user1.joinHouse(starkHouse, "Лорд");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                user2.joinHouse(starkHouse, "Рыцарь");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                user3.joinHouse(starkHouse, "Лорд");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                user1.leaveHouse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}