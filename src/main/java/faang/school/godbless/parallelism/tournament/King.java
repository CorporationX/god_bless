package faang.school.godbless.parallelism.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class King {
    public static void main(String[] args) {
        Knight sirJaimeLannister = new Knight("Sir Jaime Lannister");
        Knight sirOberynMartell = new Knight("Sir Oberyn Martell");


        Trial trial1SirJaime = new Trial("Sir Jaime Lannister", "Trial of Courage");
        Trial trial2SirJaime = new Trial("Sir Jaime Lannister", "Trial of Strategy");

        sirJaimeLannister.addTrial(trial1SirJaime);
        sirJaimeLannister.addTrial(trial2SirJaime);


        Trial trial1SirOberyn = new Trial("Sir Oberyn Martell", "Trial of Agility");
        Trial trial2SirOberyn = new Trial("Sir Oberyn Martell", "Trial of Endurance");

        sirOberynMartell.addTrial(trial1SirOberyn);
        sirOberynMartell.addTrial(trial2SirOberyn);


        ExecutorService trialsThreadPool = Executors.newFixedThreadPool(2);

        log.info("Trials begin!");

        sirJaimeLannister.startTrials(trialsThreadPool);
        sirOberynMartell.startTrials(trialsThreadPool);

        trialsThreadPool.shutdown();
    }
}
