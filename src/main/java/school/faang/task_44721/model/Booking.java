package school.faang.task_44721.model;

import java.time.LocalDateTime;

public record Booking(int id, Room room, LocalDateTime dateTimeSlot) {
}
