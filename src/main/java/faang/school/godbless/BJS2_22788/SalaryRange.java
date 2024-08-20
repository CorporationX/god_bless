package faang.school.godbless.BJS2_22788;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class SalaryRange {
    private BigDecimal leftRange;
    private BigDecimal rightRange;
    private String rangeName;

    public boolean isInRange(BigDecimal salary) {
        return salary.compareTo(leftRange) >= 0 && salary.compareTo(rightRange) <= 0;
    }
}
