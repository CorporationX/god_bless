package school.faang.wizards.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Danil Pudovkin
 * @since 24.06.2025
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"name", "year"})
public class Student {
    private final String name;
    private final int year;
    private double points;

    public void incrementPoints(double points) {
        this.points += points;
    }
}
