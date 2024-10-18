package module_3.module_3_2_Synchronized_wait_notify.ironThrone_37084;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] roles = new String[]{"King", "Queen", "Princess", "Prince", "Knight", "Servant", "Guard"};

        House house = new House(List.of(roles));

        final int countUser = 50;
        Thread[] threads = new Thread[countUser];

        for (int i = 0; i < countUser; i++) {
            int userId = i;
            User user = new User("user_" + userId);
            threads[i] = new Thread(() -> {
                user.joinHouse(house);
                user.leaveHouse(house);
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
