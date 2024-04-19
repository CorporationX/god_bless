package faang.school.godbless.FinallyNormalGame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private final Material material;
    private String pigName;

    @Override
    public void run() {
        try {
            Thread.sleep(material.getComplexity() * 1000L);
            System.out.println(getPigName() + "'s " + material.getName() + " house has been built!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
