package faang.school.godbless.jobAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {
    private String position;
    private List<String> requirements;
    private double salary;
    private String location;
    private String dateAdded;
}
