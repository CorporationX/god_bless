package school.faang.iron_throne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        House house = new House();
        User userOne = new User("Bob");
        User userTwo = new User("Rob");
        User userTree = new User("Jo");
        User userFour = new User("Tim");
        User userFive = new User("Mo");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> userOne.joinHouse(house));
        executorService.submit(() -> userTwo.joinHouse(house));
        executorService.submit(() -> userTree.joinHouse(house));
        executorService.submit(() -> userFour.joinHouse(house));
        executorService.submit(userTwo::leaveHouse);
        executorService.submit(() -> userFive.joinHouse(house));
        executorService.shutdown();
    }
}
