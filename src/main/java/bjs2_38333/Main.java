package bjs2_38333;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Future<Robot>> winners = new ArrayList<>();
        Battle battle = new Battle();
        List<Robot> robots = List.of(
                new Robot("robot1", random.nextInt(100), random.nextInt(100)),
                new Robot("robot2", random.nextInt(100), random.nextInt(100)),
                new Robot("robot3", random.nextInt(100), random.nextInt(100)),
                new Robot("robot4", random.nextInt(100), random.nextInt(100)),
                new Robot("robot5", random.nextInt(100), random.nextInt(100)),
                new Robot("robot6", random.nextInt(100), random.nextInt(100)));

        int left = 0;
        int right = robots.size() - 1;
        while (left < right) {
            winners.add(battle.fight(robots.get(left), robots.get(right)));
            left++;
            right--;
        }

        winners.forEach(winner -> {
            try {
                Robot robot = winner.get();
                System.out.println("Победитель битвы: " + robot.getName());
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage(), e);
            }
        });
        battle.shutdown();
    }
}
