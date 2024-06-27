package faang.school.godbless.BJS2_10959;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight Arthur = new Knight("Arthur");
        Knight Frank = new Knight("Frank");
        Trial horseRace = new Trial("Horse race", Arthur.getName());
        Trial swordFight = new Trial("Sword fight", Arthur.getName());
        Trial bowShooting = new Trial("Bow shooting", Frank.getName());
        Trial spearFight = new Trial("Joust", Frank.getName());
        Arthur.addTrial(horseRace);
        Arthur.addTrial(swordFight);
        Frank.addTrial(bowShooting);
        Frank.addTrial(spearFight);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(Arthur::startTrials);
        service.submit(Frank::startTrials);
        service.shutdown();
        try {
            service.awaitTermination(20, TimeUnit.SECONDS);
            System.out.println("The tournament has finished");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
