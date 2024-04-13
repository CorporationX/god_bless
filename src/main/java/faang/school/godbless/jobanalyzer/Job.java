package faang.school.godbless.jobanalyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class Job {
    private final String vacancy;
    private final int salary;
    private final String location;
    private final LocalDateTime createdAt;
    private final List<String> requirements;
}
