package school.faang.Module1.Booking_organization_system;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Booking {
    private int bookingId;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public boolean bookingConflicts(LocalDate newCheckInDate, LocalDate newCheckOutDate) {
        return !(newCheckInDate.isAfter(checkOutDate) || newCheckOutDate.isBefore(checkInDate));
    }
}