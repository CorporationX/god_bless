package school.faang.sprint_1.task_45310;

public record Student(int id, String name) {

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
