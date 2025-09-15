package school.faang.bjs2_89569;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knight {
    @Getter
    private String name;
    @Getter
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (trial == null) {
            System.out.println("Trial cannot be null");
        }
        trials.add(trial);
    }

    public void startTrials() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Trial trial : trials) {
            executor.submit(trial);
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        Knight knightOne = new Knight("Knight One");
        Knight knightTwo = new Knight("Knight Two");

        knightOne.addTrial(new Trial(knightOne.getName(), "trial of agility"));
        knightOne.addTrial(new Trial(knightOne.getName(), "trial of strength"));
        knightOne.addTrial(new Trial(knightOne.getName(), "trial of intelligence"));

        knightTwo.addTrial(new Trial(knightTwo.getName(), "trial of vitality"));
        knightTwo.addTrial(new Trial(knightTwo.getName(), "trial of luck"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Knight> knights = List.of(knightOne, knightTwo);
        for (Knight knight : knights) {
            for (Trial trial : knight.getTrials()) {
                executor.submit(trial);
            }
        }
        executor.shutdown();
    }
}
