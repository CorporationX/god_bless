package faang.school.godbless.task.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight martell = new Knight("Oberyn Martell");
        Knight clegane = new Knight("Gregor Clegane");

        martell.addTrial(new Trial("Oberyn Martell", "Swords fight"));
        martell.addTrial(new Trial("Oberyn Martell", "Fist fight"));
        clegane.addTrial(new Trial("Gregor Clegane", "Swords fight"));
        clegane.addTrial(new Trial("Gregor Clegane", "Fist fight"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(martell);
        executorService.submit(clegane);

        executorService.shutdown();
    }
}
