package school.BJS2_38902;

import lombok.Getter;
import java.util.List;

@Getter
public class School implements Comparable<School> {

    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    @Override
    public int compareTo(School o) {
        return Integer.compare(getTotalPoints(), o.getTotalPoints());
    }
}
