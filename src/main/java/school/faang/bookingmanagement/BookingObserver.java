package school.faang.bookingmanagement;

/*
 * Related to JIRA ticket: BJS2-68742
 * */
public interface BookingObserver {
    void update(Booking booking, String status);
}
