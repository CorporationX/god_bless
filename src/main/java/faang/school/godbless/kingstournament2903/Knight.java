package faang.school.godbless.kingstournament2903;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        if (this.getTrials() == null) {
            this.trials = new ArrayList<>();
        }
        this.getTrials().add(trial);
    }
}
