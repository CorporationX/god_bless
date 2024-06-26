package faang.school.godbless.WOW;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    @Setter
    private int experience;

    public Player task(Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка в вычеслении времени выполнения задачи!");
        }
        this.setExperience(getExperience() + quest.getReward());
        return this;
    }
}
