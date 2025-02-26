package school.faang.magictournament;

import java.util.List;

public record School(String name, List<Student> team) {
    public int getTotalPoint() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
