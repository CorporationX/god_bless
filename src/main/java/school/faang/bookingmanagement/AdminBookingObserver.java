package school.faang.bookingmanagement;

import lombok.RequiredArgsConstructor;

/*
 * Related to JIRA ticket: BJS2-68742
 * */
@RequiredArgsConstructor
public class AdminBookingObserver implements BookingObserver {
    private final String adminName;

    @Override
    public void update(Booking booking, String status) {
        System.out.printf("=== Notification for Administrator %s ===\n", adminName);
        System.out.println("Booking Updated:");
        System.out.printf("Booking ID: %d\n", booking.getBookingId());
        System.out.printf("Room: %d\n", booking.getRoom().getRoomNumber());
        System.out.printf("Date: %s\n", booking.getDate());
        System.out.printf("Time Slot: %s\n", booking.getTimeSlot());
        System.out.printf("New Status: %s\n", status);
        System.out.println("---------------------------------------------");

    }
}
