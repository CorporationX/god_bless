package faang.school.godbless.WOW;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;
    public static String playerTask;

    public static synchronized String getPlayerTask() {
        return playerTask;
    }
}
