package school.faang.module1.students;

public record Subject(String name) {

    @Override
    public String toString() {
        return "Subject " + this.name();
    }
}

