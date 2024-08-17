package faang.school.godbless.task.stream.api.job.analizer;

public class GranularityMonthly implements TrendGranularity {
    @Override
    public String get(Job job) {
        return job.getDateOfCreation().toLocalDate().withDayOfMonth(1).toString();
    }

    @Override
    public String toString() {
        return "месяцам";
    }
}
