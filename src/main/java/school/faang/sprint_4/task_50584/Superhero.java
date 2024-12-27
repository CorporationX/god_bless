package school.faang.sprint_4.task_50584;

import lombok.NonNull;

public record Superhero(@NonNull String name, int strength, int agility) {

    public int getPower() {
        return strength + agility;
    }
}
