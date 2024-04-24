package faang.school.godbless.module.fourth.async.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;
    private int level;
    private int experience;
    
    public void addLevel() {
        this.level++;
    }
}
