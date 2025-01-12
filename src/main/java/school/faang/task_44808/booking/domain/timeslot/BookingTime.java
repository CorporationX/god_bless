package school.faang.task_44808.booking.domain.timeslot;

public record BookingTime(String timeSlot) {
    public BookingTime {
        validateTimeSlot(timeSlot);
    }

    private void validateTimeSlot(String timeSlot) {
        if (!timeSlot.matches("^\\d{2}:\\d{2}-\\d{2}:\\d{2}$")) {
            throw new IllegalArgumentException("Invalid booking time format. Expected: HH:mm-HH:mm");
        }
    }
}