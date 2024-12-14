package faang.school.godbless.java_sql.task_3;

public record FacultyYearPair(String faculty, String year) {

    @Override
    public String toString() {
        return faculty + " " + year;
    }
}
