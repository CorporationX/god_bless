package faang.school.godbless.BJS2_24097;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int USER_AMOUNT = 3;

    public static void main(String[] args) {
        House house = new House();
        house.putNewRoleAndQuantity("Archer", 3);
        house.putNewRoleAndQuantity("Swordman", 3);
        house.putNewRoleAndQuantity("Mage", 1);

        User userOne = new User("Frank", "Mage", house);
        User userTwo = new User("John", "Mage", house);
        User userThree = new User("Tirion", "Swordman", house);

        Runnable joinAndLeaveHouseOne = () -> {
            userOne.joinHouse();
            sleepWithTryCatchBlock(3000);
            userOne.leaveHouse();
        };

        Runnable joinAndLeaveHouseTwo = () -> {
            sleepWithTryCatchBlock(2000);
            userTwo.joinHouse();
            sleepWithTryCatchBlock(2000);
            userTwo.leaveHouse();
        };

        Runnable joinAndLeaveHouseThree = () -> {
            sleepWithTryCatchBlock(1000);
            userThree.joinHouse();
            sleepWithTryCatchBlock(5000);
            userThree.leaveHouse();
        };

        ExecutorService executor = Executors.newFixedThreadPool(USER_AMOUNT);
        executor.execute(joinAndLeaveHouseOne);
        executor.execute(joinAndLeaveHouseTwo);
        executor.execute(joinAndLeaveHouseThree);
        executor.shutdown();
    }

    private static void sleepWithTryCatchBlock(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep error");
        }
    }
}
