package vacancy.analizator;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Job {
    @NonNull
    private final String vacancyName;
    @NonNull
    private final List<String> requirements;
    private final double salary;
    @NonNull
    private final String workPlace;
    @NonNull
    private final LocalDateTime addingDate;
}
