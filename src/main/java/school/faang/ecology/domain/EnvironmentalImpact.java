package school.faang.ecology.domain;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Data
public class EnvironmentalImpact {

    private final int id;

    private final int companyId;

    /**
     * Объём выбросов (в тоннах)
     */
    private final double volume;

    private final LocalDate date;

    private final EnvironmentalImpactType type;
}
