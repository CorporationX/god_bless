package faang.school.godbless.starwarsarena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Robot> winnerRobot = executorService.submit(() -> fightRobot(firstRobot, secondRobot));
        executorService.shutdown();
        if(executorService.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("битва была успешно завершена");
        }else {
            System.out.println("не все быитвы были закончены за отведенное время");
        }
        return winnerRobot;
    }

    private Robot fightRobot(Robot firstRobot, Robot secondRobot) {
        Robot winnerRobot = new Robot();
        while (firstRobot.getDefensePower() > 0 || secondRobot.getDefensePower() > 0) {

            firstRobot.setDefensePower(firstRobot.getDefensePower() - secondRobot.getAttackPower());
            if (firstRobot.getDefensePower() <= 0) {
                winnerRobot = secondRobot;
                break;
            }
            secondRobot.setDefensePower(secondRobot.getDefensePower() - firstRobot.getAttackPower());
            if (secondRobot.getDefensePower() <= 0) {
                winnerRobot = firstRobot;
                break;
            }
        }
        return winnerRobot;
    }
}


