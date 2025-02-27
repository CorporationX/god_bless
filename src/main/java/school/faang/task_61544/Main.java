package school.faang.task_61544;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int TIME_SPENT_IN_HOUSE = 3_000;

    public static void main(String[] args) {
        House house = new House("StarkHouse");
        User firstUser = new User("First", HouseRole.LORD);
        User secondUser = new User("Second", HouseRole.MAGE);
        User thirdUser = new User("Third", HouseRole.MAGE);
        User fourthUser = new User("Fourth", HouseRole.KNIGHT);
        User fifthUser = new User("Fifth", HouseRole.LORD);
        User sixthUser = new User("Sixth", HouseRole.KNIGHT);

        Thread firstThread = new Thread(() -> spendTimeInHouse(firstUser, house));
        Thread secondThread = new Thread(() -> spendTimeInHouse(secondUser, house));
        Thread thirdThread = new Thread(() -> spendTimeInHouse(thirdUser, house));
        Thread fourthThread = new Thread(() -> spendTimeInHouse(fourthUser, house));
        Thread fifthThread = new Thread(() -> spendTimeInHouse(fifthUser, house));
        Thread sixthThread = new Thread(() -> spendTimeInHouse(sixthUser, house));

        List<Thread> threads = new ArrayList<>(
                List.of(firstThread, secondThread, thirdThread, fourthThread, fifthThread, sixthThread)
        );
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("Ожидание завершения потока \"%s\" прервано%n", thread.getName());
            }
        }
    }

    private static void spendTimeInHouse(@NonNull User user, @NonNull House house) {
        try {
            user.joinHouse(house);
            Thread.sleep(TIME_SPENT_IN_HOUSE);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Нахождение \"%s\" в доме \"%s\" прервано%n", user.getName(), house.getName());
            throw new RuntimeException(e);
        } finally {
            user.leaveHouse();
        }
    }
}
