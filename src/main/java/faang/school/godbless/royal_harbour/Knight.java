package faang.school.godbless.royal_harbour;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Knight implements Runnable {

    private final String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    @Override
    @SneakyThrows
    public void run() {
        for (var trial : trials) {
            System.out.println(name + " pushing a \"" + trial.getTrialName() + "\" trial!");
            Thread.sleep(new Random().nextInt(10_000));
            System.out.println(name + " is done with his trial!");
        }
        System.out.println("\n" + name + " has finished his trials!!!\n");
    }
}
