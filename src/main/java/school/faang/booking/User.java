package school.faang.booking;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class User implements BookingObserver {
    private final String name;
    private final String email;

    @Override
    public void update(Booking booking, String status) {
        log.info("Письмо для {} отправлено по адресу {} c содеражнием:\n" +
                        "УВЕДОМЛЕНИЕ: Брониорвание {} для комнаты {} - {}",
                this.name, this.email, booking.getBookingId(), booking.getRoom().getRoomNumber(), status);
    }
}
