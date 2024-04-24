package faang.school.godbless.theTournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Knight {
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrail(Trial trial){
        trials.add(trial);
    }

}
