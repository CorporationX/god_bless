package school.faang.models;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class EnvironmentalImpact {
    private final int id;
    private final int companyId;
    private final double volume;
    private final LocalDate date;
    private final EmissionType type;

    public EnvironmentalImpact(int id, int companyId, double volume, LocalDate date, EmissionType type) {
        validateLocalDate(date);
        validateEmissionType(type);

        this.id = id;
        this.companyId = companyId;
        this.volume = volume;
        this.date = date;
        this.type = type;
    }

    private void validateLocalDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        } else if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be in the future.");
        }
    }

    private void validateEmissionType(EmissionType type) {
        if (type == null) {
            throw new IllegalArgumentException("Emission type cannot be null.");
        }
    }
}
