package school.faang.bjs274601;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;
    private int level = 1;
    private int experience = 0;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
