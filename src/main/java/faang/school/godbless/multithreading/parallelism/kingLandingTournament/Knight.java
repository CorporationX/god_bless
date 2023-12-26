package faang.school.godbless.multithreading.parallelism.kingLandingTournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

    public int getTaskTime() {
        return new Random().nextInt(5000, 15000);
    }
}
