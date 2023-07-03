package faang.school.godbless.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Peter");
        Knight knight2 = new Knight("Robert");
        knight1.addTrial(new Trial("Peter", "Fight with dragon"));
        knight2.addTrial(new Trial("Robert", "Fight with the giant"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
