package faang.school.godbless.multithreading.broforce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player{

    String name;
    private int lives;

    public static void getDamage(Player player) {
        player.setLives(player.getLives() - 1);

        System.out.printf("> %s has died. Lifes = %s%n", player.getName(), player.getLives());
    }

}
