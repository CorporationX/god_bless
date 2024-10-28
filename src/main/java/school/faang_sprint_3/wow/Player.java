package school.faang_sprint_3.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;

    public void addExp(int exp) {
        this.experience += exp;
    }
}
