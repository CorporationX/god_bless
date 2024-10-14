package school.faang.job.analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JobStatistic {
    private int numOfJobsDelta;
    private int numOfRequirements;

    @Override
    public String toString() {
        return "Количество новых вакансий за текущий период: " + numOfJobsDelta +
                " Количество новых навыков за текущий период: " + numOfRequirements;
    }
}
