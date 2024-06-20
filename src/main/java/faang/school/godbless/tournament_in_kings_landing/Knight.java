package faang.school.godbless.tournament_in_kings_landing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
public class Knight {
    private String name;
    private ArrayList<Trial> trials;

    public void addTrial(Trial trial){
        trials.add(trial);
    }

    public void startTrials(){
        for (Trial trial : trials){
            trial.run();
        }
    }
}
