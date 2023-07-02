package faang.school.godbless.task.jobAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class Job {
    private String name;
    private int salary;
    private String location;
    private LocalDate date;
    private List<String> requiredSkills;
}
