package school.faang.task_50939;

import java.util.List;

public record School(String name, List<Student> studentList) {
    public int getTotalPoints() {
        return studentList.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
