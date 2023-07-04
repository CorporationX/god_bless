package faang.school.godbless.starwars;

import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RequiredArgsConstructor
public class Battle { // по сути если Battle подразумевает участие двух роботов и в main мы создаем два объекта Battle, то я подумал, что
                        // лучше будет создать конструктор для определения robot1 и robot2, нежели чем просто передача этих объектов в методы, как сказано в условии к задаче

    private final Robot robot1;
    private final Robot robot2;

    public Future<Robot> fight() {
        System.out.println("Started fight between " + robot1.name() + " and " + robot2.name());

        Robot winner;

        if ((robot1.attackPower() + robot1.defencePower()) > (robot2.attackPower() + robot2.defencePower())) {
            winner = robot1;
        } else if ((robot1.attackPower() + robot1.defencePower()) == robot2.attackPower() + robot2.defencePower()) {
            int random = new Random().nextInt(1, 2);

            if (random == 1) {
                winner = robot1;
            } else {
                winner = robot2;
            }
        } else {
            winner = robot2;
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return executorService.submit(() -> winner);
    }
}
