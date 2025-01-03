package school.faang.bjs251634.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
public class School {

    private String name;
    private List<Student> students;

    public int getTotalPoint() {
        return students.stream().mapToInt(Student::getPoints).sum();
    }
}
