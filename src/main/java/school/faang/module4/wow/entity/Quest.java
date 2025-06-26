package school.faang.module4.wow.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import school.faang.module4.wow.constant.Constant;

@Getter
@Setter
public class Quest {

    private String name;
    private int difficulty;
    private int reward;


    public Quest(@NonNull String name, int difficulty, int reward) {
        if (difficulty < Constant.MIN_DIFFICULTY || Constant.MAX_DIFFICULTY < difficulty) {
            throw new IllegalArgumentException(String.format("difficulty value should be between %d and %d",
                    Constant.MIN_DIFFICULTY, Constant.MAX_DIFFICULTY));
        }
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public int getMinReqPlayerLvl() {
        int levelsPerDiff = Constant.MAX_PLAYER_LVL / Constant.MAX_DIFFICULTY;
        return levelsPerDiff * difficulty - levelsPerDiff;
    }

    public long getQuestTimeInMillis() {
        difficulty = Math.max(Constant.MIN_DIFFICULTY, Math.min(Constant.MAX_DIFFICULTY, difficulty));
        double normalized = (double) (difficulty - Constant.MIN_DIFFICULTY)
                / (double) (Constant.MAX_DIFFICULTY - Constant.MIN_DIFFICULTY);
        double time = Constant.QUEST_MIN_TIME + (Constant.QUEST_MAX_TIME + Constant.QUEST_MIN_TIME) * normalized;
        return (long) (time * Constant.ONE_S_IN_MS);
    }
}
