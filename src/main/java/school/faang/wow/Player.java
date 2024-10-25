package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExp(int exp){
        this.experience += exp;
    }
}
