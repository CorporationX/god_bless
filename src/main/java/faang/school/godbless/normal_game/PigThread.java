package faang.school.godbless.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread{
    private String pigName;
    private Material material;

    @Override
    public void run() {
        try {
            System.out.println("Pig " + getPigName() + " starts building a " + getMaterial() + " house.");
            Thread.sleep(5000);
            System.out.println(("Pig " + getPigName() + " finished building a " + getMaterial() + " house."));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
