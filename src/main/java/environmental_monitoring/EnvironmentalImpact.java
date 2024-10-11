package environmental_monitoring;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private String date;
    private ImpactType type;
}
