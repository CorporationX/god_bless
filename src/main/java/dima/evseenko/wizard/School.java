package dima.evseenko.wizard;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> teem;

    public int getTotalPoints() {
        return teem.stream().mapToInt(Student::getPoints).sum();
    }
}
