package school.faang.sprint_3.task_47670;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<PigThread> gameThreads = new ArrayList<>();
        gameThreads.add(new Pig3Thread("Nif-Nif", "straw"));
        gameThreads.add(new Pig2Thread("Nuf-Nuf", "sticks"));
        gameThreads.add(new Pig1Thread("Naf-Naf", "bricks"));

        for (PigThread gameThread : gameThreads) {
            gameThread.start();
        }

        try {
            for (PigThread gameThread : gameThreads) {
                gameThread.join();
            }
            System.out.println("Game finished");
        } catch (InterruptedException e) {
            System.out.println("Game thread interrupted");
        }
    }
}