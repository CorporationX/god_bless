package school.faang.task_47207;

public record User(long id, String name) {
    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }
}
