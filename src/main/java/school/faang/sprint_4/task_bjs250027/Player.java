package school.faang.sprint_4.task_bjs250027;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    @NonNull
    private final String name;
    private int level;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
