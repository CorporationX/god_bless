package school.faang.godbless.bjs2_39338;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class School {
    private final List<Student> team = new ArrayList<>();
    private String name;

    public School(String name, List<Student> students) {
        this.name = name;
        team.addAll(students);
    }

    public int getTotalPoints() {
        synchronized (team) {
            return team.stream().mapToInt(Student::getPoints).sum();
        }
    }

    public void addPoints(int points) {
        synchronized (team) {
            team.forEach(member -> member.setPoints(member.getPoints() + points));
        }
    }
}
