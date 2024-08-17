package faang.school.godbless.task.stream.api.job.analizer;

import java.time.DayOfWeek;

public class GranularityWeekly implements TrendGranularity{
    @Override
    public String get(Job job) {
        return job.getDateOfCreation().toLocalDate().with(DayOfWeek.MONDAY).toString();
    }

    @Override
    public String toString() {
        return "неделям";
    }
}
