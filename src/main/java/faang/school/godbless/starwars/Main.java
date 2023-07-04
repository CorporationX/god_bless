package faang.school.godbless.starwars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Andrey", 54, 43);
        Robot robot2 = new Robot("Denis", 32, 44);
        Robot robot3 = new Robot("Vlad", 43, 57);
        Robot robot4 = new Robot("Max", 57, 43);

        Battle battle1 = new Battle(robot1, robot2);
        Battle battle2 = new Battle(robot3, robot4);

        Future<Robot> fight1 = battle1.fight();
        Future<Robot> fight2 = battle2.fight();

        System.out.println("Accepting your bets on fights");

        try {
            System.out.println("Winner of the first fight is: " + fight1.get().name());
            System.out.println("Winner of the second fight is: " + fight2.get().name());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
