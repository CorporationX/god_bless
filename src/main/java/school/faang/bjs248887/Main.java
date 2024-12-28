package school.faang.bjs248887;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roles = Arrays.asList("Lord", "Knight", "Mage");
        House house = new House("Stark", roles);

        for (int i = 1; i < 8; i++) {
            userProcess(new User("user" + i), house);
        }
    }

    private static void userProcess(User user, House house) {
        Thread t = new Thread(() -> {
            try {
                user.joinHouse(house);
                Thread.sleep(2000);
                user.leaveHouse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
    }
}