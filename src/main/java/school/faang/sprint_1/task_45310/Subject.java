package school.faang.sprint_1.task_45310;

public record Subject(int id, String name) {

    @Override
    public String toString() {
        return "Subject{id=" + id + ", name='" + name + "'}";
    }
}
