package faang.school.godbless.triWizardTournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class School {
    private String name;
    private List<Student> team;
    private int totalPoints;

    public School(String name) {
        this.name = name;
        this.team = new ArrayList<>();
        this.totalPoints = 0;
    }

    public int getTotalPoints(){
        totalPoints = team.stream().mapToInt(Student::getPoints).sum();
        return totalPoints;
    }
}
