package school.faang.bjs2_92858;

import java.util.List;

public record School(String name, List<Student> team) {
    public School(String name, List<Student> team) {
        this.name = DataValidator.requireNotBlank(name);
        this.team = DataValidator.requireNotNullOrEmpty(team);
    }

    public int getTotalPoints() {
        return team().stream().mapToInt(Student::getPoints).sum();
    }
}