package bjs2_32460;

public record FucYea(String faculty, Integer year) {
    public FucYea(Student student) {
        this(student.getFaculty(), student.getYear());
    }
}