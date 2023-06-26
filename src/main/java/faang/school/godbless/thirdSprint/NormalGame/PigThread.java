package faang.school.godbless.thirdSprint.NormalGame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PigThread extends Thread {
    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строить свои дом из " + getMaterial());
    }
}
