package school.faang.sprint_1.task_45263;

public record Student(int id, String name) {
    @Override
    public String toString() {
        return name;
    }
}
