package faang.school.godbless.sprint_3.multithreading_future.star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot firstRobot = new Robot("FCP-23", 5, 10);
        Robot secondRobot = new Robot("FCP-101", 7, 16);
        Robot thirdRobot = new Robot("MKB-2021", 2, 16);
        Robot fourthRobot = new Robot("VTK-2023", 5, 10);
        Future<Robot> first = battle.fight(firstRobot, secondRobot);
        Future<Robot> second = battle.fight(thirdRobot, fourthRobot);
        try {
            Robot firstWinner = first.get();
            Robot secondWinner = second.get();
            System.out.println("Первую схватку выиграл: " + firstWinner.getName());
            System.out.println("Вторую схватку выиграл: " + secondWinner.getName());
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }

    }
}
