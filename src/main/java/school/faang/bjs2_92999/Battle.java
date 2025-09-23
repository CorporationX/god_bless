package school.faang.bjs2_92999;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Future;

@Slf4j
public class Battle {

    Future<Robot> fight(Robot robot1, Robot robot2) {
        log.info("Начинается битва между роботами {} и {}", robot1.getName(), robot2.getName());
        if ((robot1.getAttackPower() - robot1.getDefensePower())
                > robot2.getAttackPower() - robot2.getDefensePower()) {
            return robot1;

        } else {
            return robot2;
        }
    }
}
