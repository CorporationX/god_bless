package faang.school.godbless.multithreading.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int THREAD_POOL = 2;
    private static final List<Knight> knights = new ArrayList<>();

    public static void main(String[] args) {

        Knight bob = new Knight("Bob");
        bob.addTrial(new Trial("Bob", "Go!"));
        bob.addTrial(new Trial("Bob", "Fly to the moon"));
        knights.add(bob);

        Knight eve = new Knight("Eve");
        eve.addTrial(new Trial("Eve", "Swim to the sea"));
        eve.addTrial(new Trial("Eve", "Defense your castle"));
        knights.add(eve);

        startTrials();
    }

    public static void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
        knights.stream()
                .flatMap(knight -> knight.getTrials().stream())
                .forEach(executorService::submit);
        executorService.shutdown();
    }
}
