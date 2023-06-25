package faang.school.godbless.job_analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Job {

    private String jobPosition;
    private List<String> skillRequirements;
    private int salaryProposition;
    private String jobLocation;
    private LocalDate vacancyAddedDate;
}
