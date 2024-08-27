package faang.school.godbless.WOW;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.beans.IntrospectionException;

@AllArgsConstructor
@Getter
public class Quest {
    private String name;
    private int difficulty;

    private int reward;

    public Player start(Player player) {
        System.out.println(player.getName() + " начал выполнение квеста " + name);
        try {
            Thread.sleep(1000L * difficulty);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println(player.getName() + " закончил выполнение квеста " + name);
        player.setExperience(player.getExperience() + reward);
        return player;
    }
}
