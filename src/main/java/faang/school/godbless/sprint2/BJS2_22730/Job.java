package faang.school.godbless.sprint2.BJS2_22730;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class Job {
    private String jobTitle;
    private List<String> skills;
    private int proposedSalary;
    private String location;
    private LocalDate vacancyPublishingDate;
}
