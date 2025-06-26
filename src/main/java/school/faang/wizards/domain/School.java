package school.faang.wizards.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 24.06.2025
 */
@Data
@AllArgsConstructor
@ToString(of = "name")
@EqualsAndHashCode(of = "name")
public class School {

    private final String name;
    private List<Student> team;

    public double getTotalPoints() {
        return team.stream()
                .mapToDouble(Student::getPoints)
                .sum();
    }
}
