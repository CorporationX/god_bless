package school.faang.task_44723.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_44723.BookingObserver;

@Slf4j
@ToString
@AllArgsConstructor
public class User implements BookingObserver {
    private final String name;

    @Override
    public void update(Booking booking, BookingStatus status) {
        if (status == BookingStatus.BOOKED) {
            log.info("Hi {}, this is the booking notifier again, "
                            + "I hasten to inform you that {} "
                            + "WAS BOOKED on the date {}, "
                            + "at the time from {} to {} !!!",
                    name,
                    booking.getRoom(),
                    booking.getDate(),
                    booking.getStartTime(),
                    booking.getEndTime()
            );
        } else if (status == BookingStatus.CANCELLED) {
            log.info("Hi {}, this is the booking notifier again, "
                            + "I hasten to inform you that "
                            + "the reservation for {} WAS CANCELLED "
                            + "on the date {}, at the time from {} to {} !!!",
                    name,
                    booking.getRoom(),
                    booking.getDate(),
                    booking.getStartTime(),
                    booking.getEndTime()
            );
        }
    }
}
