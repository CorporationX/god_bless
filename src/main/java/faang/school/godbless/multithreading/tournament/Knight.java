package faang.school.godbless.multithreading.tournament;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight {

    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(@NonNull Trial trial) {
        trials.add(trial);
    }
}
