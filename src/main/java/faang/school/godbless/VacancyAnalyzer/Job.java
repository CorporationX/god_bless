package faang.school.godbless.VacancyAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private String title;
    private List<String> requirements;
    private int salary;
    private String location;
    private Date createdAt;

}
