package school.faang.task_50124;

public record Quest(String name, int difficulty, int reward) {
    public Quest {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

}
