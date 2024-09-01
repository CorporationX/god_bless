package faang.school.godbless.BJS2_24106;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map<String, Boolean> availableRoles = getAvailableRoles();
        House house = new House(availableRoles, availableRoles.size());
        User arya = new User("Arya");
        User jon = new User("Jon");
        User sansa = new User("Sansa");
        User bran = new User("Bran");
        startUserThread(arya, house, "Lord");
        startUserThread(jon, house, "Knight");
        startUserThread(sansa, house, "Maester");
        startUserThread(bran, house, "Knight");
    }

    public static Map<String, Boolean> getAvailableRoles() {
        Map<String, Boolean> availableRoles = new HashMap<>();
        availableRoles.put("Lord", Boolean.TRUE);
        availableRoles.put("Knight", Boolean.TRUE);
        availableRoles.put("Maester", Boolean.TRUE);
        return availableRoles;
    }

    public static void startUserThread(User user, House house, String role) {
        new Thread(() -> {
            user.joinHouse(house, role);
            try {
                Thread.sleep(new Random().nextInt(2000) + 6001);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse();
        }).start();
    }
}
