package school.faang.truancy;

public record StudentRecord(String faculty, int year) {
    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }
}