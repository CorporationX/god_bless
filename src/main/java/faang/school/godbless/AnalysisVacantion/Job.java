package faang.school.godbless.AnalysisVacantion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class Job {
    private String name;
    private String location;
    private List<String> requirements;
    private int salary;
    private LocalDateTime addDate;

    public String getSalaryRange() {
        int salary = getSalary();
        if (salary <= 50000) {
            return "0-50k";
        } else if (salary <= 100000) {
            return "50k-100k";
        } else if (salary <= 150000) {
            return "100k-150k";
        } else {
            return "150k-200k";
        }
    }

}
