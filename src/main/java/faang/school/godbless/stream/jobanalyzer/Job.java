package faang.school.godbless.stream.jobanalyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Job {
    private String title;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate addedDate;
}
