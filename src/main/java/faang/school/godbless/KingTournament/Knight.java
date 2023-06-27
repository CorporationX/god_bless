package faang.school.godbless.KingTournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial){
        trials.add(trial);
    }

    public List<Thread> startTrials(){
        return new ArrayList<>(trials);
    }
}
