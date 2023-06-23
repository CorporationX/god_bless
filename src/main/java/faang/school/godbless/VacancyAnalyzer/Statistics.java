package faang.school.godbless.VacancyAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    private List<Date> range;
    private Integer vacancyQuantity;
    private List<String> mostRequiredSkills;
    private Map<String, Integer> salaryRanges;
    private List<String> mostPopularLocations;
}
