package BJS2_5690;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight anduin = new Knight("Anduin Wrynn");
        Knight sylvanas = new Knight("Sylvanas Windrunner");
        ExecutorService service = Executors.newFixedThreadPool(2);

        anduin.addTrial(new Trial(anduin.getName(), "Sword battle"));
        anduin.addTrial(new Trial(anduin.getName(), "Chain battle"));
        sylvanas.addTrial(new Trial(sylvanas.getName(), "Mage battle"));
        sylvanas.addTrial(new Trial(sylvanas.getName(), "Chain battle"));

        service.submit(anduin::startTrials);
        service.submit(sylvanas::startTrials);

        service.shutdown();
    }
}
