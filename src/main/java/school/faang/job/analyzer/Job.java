package school.faang.job.analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate datePosted;
}
