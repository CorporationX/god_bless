package environmental_monitoring;

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
    private ImpactType type;
}
