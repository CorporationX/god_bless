package school.faang.bjs250985;

import java.util.List;

public record School(String name, List<Student> students) {

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void updateStudentPoints(List<Student> students, Task task) {
        students.forEach(student ->
                student.setPoints(student.getPoints() + task.reward() / students.size()));
    }
}