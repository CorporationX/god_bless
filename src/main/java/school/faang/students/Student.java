package school.faang.students;

public record Student(String name) {

    @Override
    public String toString() {
        return "Student " + this.name();
    }
}
