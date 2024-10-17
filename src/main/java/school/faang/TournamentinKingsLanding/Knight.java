package school.faang.TournamentinKingsLanding;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
@Getter
@Setter
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
        this.trials = new ArrayList<>();
    }

    public void addTrial(Trial trial) {
        this.trials.add(trial);
    }

    public void startTrials(ExecutorService service) {
        trials.forEach(service::execute);
    }
}
