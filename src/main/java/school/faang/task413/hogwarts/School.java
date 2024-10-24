package school.faang.task413.hogwarts;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class School {
    @NonNull
    private String name;
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);

    }

    public int getTotalPoints() {
        return students.stream()
                .map(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(0);
    }

}
