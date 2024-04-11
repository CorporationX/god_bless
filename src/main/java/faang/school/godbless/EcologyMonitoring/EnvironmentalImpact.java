package faang.school.godbless.EcologyMonitoring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private String companyName;
    private double volume;
    private LocalDate date;
    private ImpactType type;
}
