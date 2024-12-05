package school.faang.task44828;

import lombok.Getter;

@Getter
public enum Weather {
    MIN_TEMP(-40),
    MAX_TEMP(40),
    MAX_HUMIDITY(100),
    MIN_HUMIDITY(0),
    MIN_TIMESTAMP(0);

    private final double value;

    Weather(double value) {
        this.value = value;
    }
}
