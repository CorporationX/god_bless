package faang.school.godbless.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        int pointsCounter = 0;
        for(Student student : team) {
            pointsCounter += student.getPoints();
        }
        return pointsCounter;
    }
    public void addInTeam(Student student) {
        team.add(student);
    }
}
