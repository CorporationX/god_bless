package faang.school.godbless.job_alalyzer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class JobChanges {
    private long numberOfJobs;
    private Map<String, Long> jobRequiredSkills;
    private Map<String, Long> location;
}
