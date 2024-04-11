package faang.school.godbless.VacancyAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalaryRange {
    private String name;
    private int lower;
    private int higher;
}
