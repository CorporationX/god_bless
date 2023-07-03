package faang.school.godbless.spring_4.star_wars_arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<Future<Robot>> futures = new ArrayList<>();

        Battle battle = new Battle();

        List<List<Robot>> robots = new ArrayList<>();

        char[] chars = {'3', '-', '5', '+', '6', 'R', 'W', 'V'};

        Supplier<Integer> supplierRandomInt = () -> new Random().nextInt(10);

        Supplier<Robot> supplier = () -> {
            return new Robot(String.valueOf(chars[new Random().nextInt(chars.length)]) +
                    chars[new Random().nextInt(chars.length)] +
                    chars[new Random().nextInt(chars.length)], supplierRandomInt.get(), supplierRandomInt.get());
        };

        for (int i = 0; i < 5; i++) {
            robots.add(List.of(supplier.get(), supplier.get()));
        }

        for (List<Robot> robot : robots) {
            futures.add(battle.fight(robot.get(0), robot.get(1)));
        }

        battle.pool.shutdown();

        for (Future<Robot> future : futures) {
            try {
                System.out.println("The winner of the battle: " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        for (List<Robot> robot : robots) {
            System.out.println(robot);
        }
    }
}
