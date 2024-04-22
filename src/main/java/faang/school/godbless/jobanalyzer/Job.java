package faang.school.godbless.jobanalyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Job {
    private String vacancy;
    private int salary;
    private String location;
    private LocalDateTime createdAt;
    private List<String> requirements;
}
