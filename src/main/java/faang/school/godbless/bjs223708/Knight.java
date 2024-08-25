package faang.school.godbless.bjs223708;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Knight {
    private final String name;
    List<Trial> trials = new ArrayList<>();

    public Knight addTrial(Trial trial) {
        this.trials.add(trial);
        return this;
    }
}