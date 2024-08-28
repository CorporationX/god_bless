package faang.school.godbless.BJS2_24278;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int lives;

    public static void getDamage(Player player) {
        player.lives = player.getLives() - 1;
        System.out.printf("%s has died. Lives = %s%n", player.getName(), player.getLives());
        System.out.println("===============================");
    }
}
