package faang.school.godbless.ThirdSprint.BJS2_23533;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class King {
    static ExecutorService service = Executors.newFixedThreadPool(2);


    public static void main(String[] args) {
        Knight knightJames = new Knight("Jaime Lannister");
        Knight knightBrienne = new Knight("Brienne of Tarth");

        Trial trial = new Trial("sword battle");
        Trial trial2 = new Trial("arching");

        knightBrienne.addTrial(trial);
        knightJames.addTrial(trial);

        knightJames.addTrial(trial2);
        knightBrienne.addTrial(trial2);

        knightJames.startTrials();
        knightBrienne.startTrials();

        service.shutdown();
    }
}
