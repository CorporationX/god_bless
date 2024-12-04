package school.faang.task_43514.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Booking {
    private int id;
    private Room room;
    private LocalDateTime dateTimeSlot;
}
