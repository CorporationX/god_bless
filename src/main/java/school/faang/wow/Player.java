package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;

//    public void addExperience(int experience) {
//        this.experience += experience;
//    }
}
