package TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor

public class School {
    private String name;
    private List<Student> team = new ArrayList<>();

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
