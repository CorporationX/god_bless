package faang.school.godbless.tournament_in_kings_landing;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knightArtur = new Knight("Artur", new ArrayList<>());
        Knight knightJohn = new Knight("John", new ArrayList<>());

        knightArtur.addTrial(new Trial(knightArtur.getName(),"duel"));
        knightArtur.addTrial(new Trial(knightArtur.getName(),"archery"));
        knightJohn.addTrial(new Trial(knightJohn.getName(),"sword fight"));
        knightJohn.addTrial(new Trial(knightJohn.getName(),"duel"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(knightArtur::startTrials);
        executor.submit(knightJohn::startTrials);
        executor.shutdown();
    }
}
