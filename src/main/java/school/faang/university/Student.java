package school.faang.university;

public record Student(String name, String faculty, int year) {
    @Override
    public String toString() {
        return "Student: {" + name + ", " + faculty + ", " + year + "}";
    }
}
