package faang.school.godbless.stream_api.task5eco;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsAggregator {
    public static Map<String, Double> aggregateEnvironmentalImpacts(List<EnvironmentalImpact> impacts, Date startDate, Date endDate, ImpactType type) {
        Map<String, Double> result = new HashMap<>();

        for (EnvironmentalImpact impact : impacts) {
            if (impact.getType() == type && impact.getDate().after(startDate) && impact.getDate().before(endDate)) {
                result.merge(Integer.toString(impact.getCompanyId()), impact.getVolume(), Double::sum);
            }
        }

        return result;
    }
}
