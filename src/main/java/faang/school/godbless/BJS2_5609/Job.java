package faang.school.godbless.BJS2_5609;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Job {
    private String jobTitle;
    private String positionTitle;
    private List<String> requirementForCandidates;
    private int proposedSalary;
    private String location;
    private LocalDateTime createdAt;
}
