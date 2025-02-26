package school.faang.sprint.fourth.wow;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Player {
    @NonNull
    private String name;
    private int level;
    private int experience;

    public Player(@NonNull String name, int level, int experience) {
        validateData(name, level, experience);
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public synchronized void setExperience(int experience) {
        this.experience = experience;
    }

    private void validateData(String name, int level, int experience) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (level < 0) {
            throw new IllegalArgumentException("Level must be greater than or equal 0.");
        }
        if (experience < 0) {
            throw new IllegalArgumentException("Experience must be greater than or equal 0.");
        }
    }
}
