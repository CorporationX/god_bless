package school.faang.environmental.monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmissionStatistic {
    private double totalVolOverYear;
    private double avgVolOverMonth;
    private double minVolOverMonth;
}
