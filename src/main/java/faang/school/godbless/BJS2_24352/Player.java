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

    public static void getDamage(Player player){
        player.setLives(player.getLives() - 1);
        System.out.println(player.getName() + " has died. Lifes = " + player.getLives());
    }
}
