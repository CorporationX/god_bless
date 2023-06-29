package faang.school.godbless.job_analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Job {

    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private String dateAdded;

    public Job() {
    }
}
