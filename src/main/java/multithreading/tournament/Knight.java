package multithreading.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Knight {

    private String name;
    private List<Trial> trials;

    public void addTrial(Trial trial) {
        trials.add(trial);
    }

}
