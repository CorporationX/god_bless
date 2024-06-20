package faang.school.godbless.eco_monitoring;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private LocalDate date;
    private EnvironmentalImpactType type;
}

