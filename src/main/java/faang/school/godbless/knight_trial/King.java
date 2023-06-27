package faang.school.godbless.knight_trial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {

        Knight hound = new Knight("Hound");
        hound.addTrial(new Trial(hound.getName(), "Trial 1"));
        hound.addTrial(new Trial(hound.getName(), "Trial 2"));

        Knight mountain = new Knight("Mountain");
        mountain.addTrial(new Trial(mountain.getName(), "Trial 1"));
        mountain.addTrial(new Trial(mountain.getName(), "Trial 2"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(hound :: startTrials);
        executor.submit(mountain:: startTrials);

        executor.shutdown();
    }
}
