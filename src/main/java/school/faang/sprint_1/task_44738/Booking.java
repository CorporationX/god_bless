package school.faang.sprint_1.task_44738;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Booking {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    @NonNull
    private final Room room;
    @NonNull
    private final Date dateBegin;
    @NonNull
    private final Date dateEnd;

    public Booking(@NonNull Room room, @NonNull Date dateBegin, @NonNull Date dateEnd) {
        this.id = idCounter.getAndIncrement();
        this.room = room;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }
}
