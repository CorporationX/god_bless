package school.faang.bjs2_62466;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class School {

    private String name;
    private List<Student> students = new ArrayList<Student>();

    public int getTotalPoints(List<Student> studentsList) {
        return studentsList.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
