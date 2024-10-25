package school.faang.triwizardtournament;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class School {
    private String name;
    private List<Student> team;

    @Setter(AccessLevel.NONE)
    private int totalPoints;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }






}
