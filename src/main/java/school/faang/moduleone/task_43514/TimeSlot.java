package school.faang.moduleone.task_43514;

import lombok.Getter;

@Getter
public enum TimeSlot {
    TIME_SLOT_00_04("00:00 - 04:00"),
    TIME_SLOT_04_08("04:00 - 08:00"),
    TIME_SLOT_08_12("08:00 - 12:00"),
    TIME_SLOT_12_16("12:00 - 16:00"),
    TIME_SLOT_16_20("16:00 - 20:00"),
    TIME_SLOT_20_24("20:00 - 24:00");

    private final String label;

    TimeSlot(String label) {
        this.label = label;
    }
}