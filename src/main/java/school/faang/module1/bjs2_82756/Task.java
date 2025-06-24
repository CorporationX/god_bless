package school.faang.module1.bjs2_82756;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {

    private final String name;
    private final int difficulty;
    private final int reward;

    public int calculateRewardPerStudent(School school) {
        int teamSize = school.getStudents().size();
        if (teamSize == 0) {
            return 0;
        }
        return this.reward / teamSize;
    }
}