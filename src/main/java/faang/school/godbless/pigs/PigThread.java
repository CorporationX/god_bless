package faang.school.godbless.pigs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class PigThread extends Thread{
    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строительство дома из " + getMaterial());
        try {
            Thread.sleep(getConstructionTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " закончил строительство дома из " + getMaterial());
    }

    public abstract long getConstructionTime();
}