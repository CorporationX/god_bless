package faang.school.godbless.RoyalTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Knight oleg = new Knight("Oleg");
        Knight tyler = new Knight("Tyler");
        oleg.addTrial(new Trial(oleg.getName(), "play dota"));
        oleg.addTrial(new Trial(oleg.getName(), "drop dota"));
        tyler.addTrial(new Trial(tyler.getName(), "play cs"));
        tyler.addTrial(new Trial(tyler.getName(), "drop cs"));

        oleg.startTrials();
        tyler.startTrials();
    }
}
