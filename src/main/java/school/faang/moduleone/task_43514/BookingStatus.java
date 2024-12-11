package school.faang.moduleone.task_43514;

import lombok.Getter;

@Getter
public enum BookingStatus {
    BOOKING_CREATED("BOOKING_CREATED"),
    BOOKING_CANCELED("BOOKING_CANCELED");

    private final String label;

    BookingStatus(String label) {
        this.label = label;
    }
}
