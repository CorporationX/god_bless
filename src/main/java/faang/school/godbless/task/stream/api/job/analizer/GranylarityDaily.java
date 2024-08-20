package faang.school.godbless.task.stream.api.job.analizer;

public class GranylarityDaily implements TrendGranularity {
    @Override
    public String get(Job job) {
        return job.getDateOfCreation().toLocalDate().toString();
    }

    @Override
    public String toString() {
        return "дням";
    }
}
