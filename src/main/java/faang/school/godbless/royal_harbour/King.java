package faang.school.godbless.royal_harbour;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    private final static int TRIALS_AMOUNT = 2;

    public static void main(String[] args) {
        Knight vlad = new Knight("Vlad");
        Knight vitalii = new Knight("Vitalii");

        Trial setOBS = new Trial("Vlad", "Set up the god damn OBS");
        Trial stream = new Trial("Vlad", "Not fuck the stream up");

        vlad.addTrial(setOBS);
        vlad.addTrial(stream);

        Trial spellTheName = new Trial("Vitalii", "Spell Beibarys's name correctly");
        Trial whiteBoard = new Trial("Vitalii", "Write the code on a whiteboard");

        vitalii.addTrial(spellTheName);
        vitalii.addTrial(whiteBoard);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Let the battle begin!\n");
        executorService.submit(vlad);
        executorService.submit(vitalii);

        executorService.shutdown();
    }
}
