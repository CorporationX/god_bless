package school.faang.bjs250377;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {

    public static final int DIFFICULTY = 3;
    public static final int REWARD = 100;

    private String name;
    private int difficulty;
    private int reward;

    public long getDifficulty() {
        return DIFFICULTY;
    }

    public int getReward() {
        return REWARD;
    }
}
