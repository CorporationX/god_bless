package school.faang.sprint_4.task_50822;

public record Item(String name, int power) {
    @Override
    public String toString() {
        return "name: " + name
                + ", power: " + power;
    }
}
