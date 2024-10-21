package school.faang.wow;

import lombok.Data;

@Data
public class Player {
    private final String name;
    private final int level;
    private int experience = 110;

    public void showPlayer() {
        System.out.println(name + " has completed the quest and now has "
                + experience + " experience points.");
    }

    public long getBedtime() {
        return level * 1000L;
    }
}
