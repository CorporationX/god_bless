package school.faang.threemagicians;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public Integer getTotalPoints(){
        return students.stream()
                .map(Student::getPoints)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
