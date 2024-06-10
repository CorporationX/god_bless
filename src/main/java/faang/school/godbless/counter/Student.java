package faang.school.godbless.counter;

public record Student(String name, String faculty, int year) {
    public Student {
        validate(name, faculty, year);
    }

    private void validate(String name, String faculty, int year) {
        if (name == null || name.trim().equals("") ||
                faculty == null || faculty.trim().equals("") ||
                year < 1) {
            throw new IllegalArgumentException("Check input data for student");
        }
    }
}
