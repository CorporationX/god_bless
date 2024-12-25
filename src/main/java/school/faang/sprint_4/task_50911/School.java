package school.faang.sprint_4.task_50911;

import java.util.List;

public record School(String name, List<Student> students) {

    public int getTotalPoints() {
        return this.students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
