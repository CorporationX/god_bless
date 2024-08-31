package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player start(Quest quest) {
        System.out.println(name + " начал выполнение квеста " + quest.getName());
        try {
            Thread.sleep(1000L * quest.getDifficulty());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println(name + " закончил выполнение квеста " + quest.getName());
        experience += quest.getReward();
        return this;
    }
}
