package school.faang.ecology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Data
public class Company {

    private final int id;
    private final String name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private final int totalEmployees;
}
