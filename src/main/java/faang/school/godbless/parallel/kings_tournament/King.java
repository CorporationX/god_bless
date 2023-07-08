package faang.school.godbless.parallel.kings_tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("Richard");
        Knight secondKnight = new Knight("Lancelot");
        Trial firstTrial = new Trial("Richard", "mad-Jamping");
        Trial secondTrial = new Trial("Richard", "lion fight");
        Trial thirdTrial = new Trial("Lancelot", "mad-Jamping");
        Trial fourthTrial = new Trial("Lancelot", "lion fight");
        firstKnight.addTrial(firstTrial);
        firstKnight.addTrial(secondTrial);
        secondKnight.addTrial(thirdTrial);
        secondKnight.addTrial(fourthTrial);

        firstKnight.startTrials();
        secondKnight.startTrials();
    }
}