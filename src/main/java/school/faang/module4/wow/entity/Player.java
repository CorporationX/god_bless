package school.faang.module4.wow.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import school.faang.module4.wow.constant.Constant;

@Getter
@Setter
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player(@NonNull String name, int level, int experience) {
        if (level < Constant.MIN_PLAYER_LVL || Constant.MAX_PLAYER_LVL < level) {
            throw new IllegalArgumentException(String.format("level value should be between %d and %d",
                    Constant.MIN_PLAYER_LVL, Constant.MAX_PLAYER_LVL));
        }
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public synchronized void addExperience(int experience) {
        if (level == Constant.MAX_PLAYER_LVL) {
            this.experience = computeLvlRequiredEx(level);
            return;
        }

        System.out.println("this.experience " + this.experience + " experience " + experience);
        this.experience += experience;
        for (int reqExp = computeLvlRequiredEx(level);
             this.experience >= reqExp; reqExp = computeLvlRequiredEx(level)) {
            this.experience = Math.abs(reqExp - this.experience);
            level++;
            System.out.printf("Player \"%s\" leveled up! New level %d\n", name, level);
        }
    }

    private int computeLvlRequiredEx(int lvl) {
        int reqEx = (int) (Constant.ZERO_LVL_REQUIRED_EX * Math.pow(Constant.EXP_GROWTH_FACTOR, lvl));
        return reqEx;
    }
}
