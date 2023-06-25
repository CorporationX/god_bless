package faang.school.godbless.vacancy_analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDateTime publishDate;
}
