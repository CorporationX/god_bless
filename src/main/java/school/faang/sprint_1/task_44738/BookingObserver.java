package school.faang.sprint_1.task_44738;

import lombok.NonNull;

public interface BookingObserver {
    void update(@NonNull Booking booking, @NonNull String status);
}
