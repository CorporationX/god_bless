package faang.school.godbless.jobAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Job {
    private String vacancy;
    private String location;
    private double salary;
    private List<String> requirements;
    private final LocalDate dateOfCreated = LocalDate.now();
}
