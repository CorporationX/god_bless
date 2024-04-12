package faang.school.godbless.jobanalyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Job {
    private String name;
    private List<String> requirementsForCandidates;
    private int salary;
    private String location;
    private String jobAdditions;

    public String getRangeSalary() {
        return "(" + (salary / 50000) * 50000 + " - " + ((salary / 50000) + 1) * 50000 + "):";
    }
}
