package environmental_monitoring;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyStats {
    private final double totalGasEmission;
    private final double avgGasEmission;
    private final double minGasEmission;
}
