package school.faang.wow.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
@Data
@AllArgsConstructor
@ToString(of = "name")
@EqualsAndHashCode(of = "name")
public class Player {

    private final String name;
    private int level;
    private int experience;

    public void incrementExperience(int amount) {
        experience += amount;
    }
}
