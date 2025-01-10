package school.faang.sprint4.task51042turnir;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();

    public Integer getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
