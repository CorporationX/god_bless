package faang.school.godbless.stream_api.job_analyzer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String jobTitle;
    private List<String> requirementsSkill;
    private int salary;
    private String location;
    private LocalDate vacancyDate;

}

