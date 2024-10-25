package ironThrone;

import ironThrone.entity.House;
import ironThrone.entity.User;
import ironThrone.enumeration.Role;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorJoinHouse = Executors.newFixedThreadPool(5);
        House house = new House();
        User firstUser = new User("Саня", Role.LORD);
        User secondUser = new User("Саня1", Role.KNIGHT);

        for (int i = 0; i < 50; i++) {
            executorJoinHouse.submit(threadJoinHouse(firstUser, secondUser, house));
        }

    }

    private static Runnable threadJoinHouse(User firstUser, User secondUser, House house) {
        return () -> {
            try {
                firstUser.joinHouse(house);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            try {
                secondUser.joinHouse(house);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
