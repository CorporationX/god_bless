package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private final String name;
    private final int level;
    private int experience;
//    public void setExperience(int experience){
//        this.experience=experience;
//    }
}
