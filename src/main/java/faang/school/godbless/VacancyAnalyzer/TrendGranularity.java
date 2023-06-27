package faang.school.godbless.VacancyAnalyzer;

public enum TrendGranularity {
    DAY(1), WEEK(7), MONTH(30);

    private final int days;

    TrendGranularity(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
