package school.faang.bookingmanagement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/*
 * Related to JIRA ticket: BJS2-68742
 * */
@RequiredArgsConstructor
@Getter
public class TimeSlot {
    private final LocalTime start;
    private final LocalTime end;

    public TimeSlot extent(LocalTime newEnd) {
        if (newEnd.isBefore(end) || Objects.equals(newEnd, end)) {
            throw new IllegalArgumentException("The new end is incorrect! New end must be after the current end time");
        }
        return new TimeSlot(this.start, newEnd);
    }

    public static TimeSlot getTimeSlotFromString(String timeSlot) {
        String[] timeSlotParts = timeSlot.split("-");
        LocalTime startTime = LocalTime.parse(timeSlotParts[0], DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse(timeSlotParts[1], DateTimeFormatter.ofPattern("HH:mm"));

        return new TimeSlot(startTime, endTime);
    }

    @Override
    public String toString() {
        return String.format("%s-%s", start, end);
    }
}
