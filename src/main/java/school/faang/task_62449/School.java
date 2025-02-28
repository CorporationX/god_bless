package school.faang.task_62449;

import java.util.List;

public record School(String name, List<Student> team) {
    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    @Override
    public String toString() {
        return "School: " + name + ", Team: " + team;
    }
}
