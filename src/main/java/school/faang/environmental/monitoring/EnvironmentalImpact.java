package school.faang.environmental.monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private LocalDate date;
    private EmissionType type;
}
