package faang.school.godbless.eco_monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private Double volume;
    private LocalDate date;
    private ImpactType type;
}
