package school.faang.task47104;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Granularity {
    DAILY(1),
    WEEKEND(7),
    MONTH(30);

    private final int days;
}
