package job_analyzer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private String datePosted;
}
