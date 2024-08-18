package vacancy.analizator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Job {
    @NonNull
    private String vacancyName;
    @NonNull
    private List<String> requirements;
    private double salary;
    @NonNull
    private String workPlace;
    @NonNull
    private LocalDate addingDate;
}
