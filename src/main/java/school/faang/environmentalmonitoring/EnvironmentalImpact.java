package school.faang.environmentalmonitoring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private String date;  // Format YYYY.MM.DD
    private String type;  // Initially "GAS_EMISSION"
}
