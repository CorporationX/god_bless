package school.faang.hogwarts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class School {
    private String name;
    private List<Student> studentList;

    public int getTotalPoints() {
        return studentList.stream()
                .mapToInt(Student::getReward)
                .sum();
    }

}
