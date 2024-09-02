package faang.school.godbless.BJS2_24352;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {

    private final String name;
    private int lives;

    public synchronized void dealsDamage(){
        setLives(getLives() - 1);
        System.out.println(getName() + " has died. Lifes = " + getLives());
    }
}
