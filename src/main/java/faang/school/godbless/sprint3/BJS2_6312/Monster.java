package faang.school.godbless.sprint3.BJS2_6312;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Monster {
    private String name;
    private String place;

    public static int getTimeToKill(Monster monster) {
        switch (monster.getName()) {
            case "Griffin" -> {
                return new Random().nextInt(3000) + 1000;
            }
            case "Basilisk" -> {
                return new Random().nextInt(5000) + 1000;
            }
            case "Cockatrice" -> {
                return new Random().nextInt(7000) + 1000;
            }
            case "Chort" -> {
                return new Random().nextInt(10000) + 1000;
            }
            default -> {
                return new Random().nextInt(1000) + 1000;
            }
        }
    }
}
