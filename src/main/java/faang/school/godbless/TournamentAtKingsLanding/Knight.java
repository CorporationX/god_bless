package faang.school.godbless.TournamentAtKingsLanding;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class Knight {
    private final String name;
    private final List<Trial> trials = new ArrayList<>(); //список испытаний

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial){
            trials.add(trial);
    }

    public void startTrials(ExecutorService executorService){
        for (Trial trial: trials) {
            executorService.submit(trial);
        }
    }
}
