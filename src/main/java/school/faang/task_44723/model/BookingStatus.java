package school.faang.task_44723.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum BookingStatus {
    BOOKED("Booked"),
    CANCELLED("Cancelled");

    private final String name;
}
