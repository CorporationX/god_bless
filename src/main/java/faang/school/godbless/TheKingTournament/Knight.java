package faang.school.godbless.TheKingTournament;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@ToString
public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name){
        this.name = name;
        this.trials = new ArrayList<>();

    }
}
