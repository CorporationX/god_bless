package school.faang.sprint4.task50103wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;
    private Integer level;
    private Integer experience;

    public synchronized void updateExperience(Quest quest) {
        this.experience = this.experience + quest.getReward();
    }
}
