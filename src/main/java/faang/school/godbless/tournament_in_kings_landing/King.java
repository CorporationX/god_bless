package faang.school.godbless.tournament_in_kings_landing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Robert");
        Knight knight2 = new Knight("Ned");


        knight1.addTrials(new Trial(knight1.getName(), "Duel with swords"));
        knight1.addTrials(new Trial(knight1.getName(), "Archery"));
        knight2.addTrials(new Trial(knight2.getName(), "Duel with swords"));
        knight2.addTrials(new Trial(knight2.getName(), "Archery"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
