package faang.school.godbless.vacancy.analyzer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private Integer salary;
    private String location;
    private LocalDate creationDate;
}
