package faang.school.godbless.bjs225098;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class School {
    private String name;
    private List<Student> team;

    public float getTotalPoints() {
        return this.team
                .stream()
                .map(Student::getPoints)
                .reduce(0.0f, Float::sum);
    }
}