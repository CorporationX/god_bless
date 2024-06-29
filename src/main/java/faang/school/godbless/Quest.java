package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

////Создайте класс Quest с полями name, difficulty, и reward.
@AllArgsConstructor
@Setter
@Getter
@Data
public class Quest {
    private String name;
    private int difficulty;
    private int reward;

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getReward() {
        return this.reward;
    }
}
