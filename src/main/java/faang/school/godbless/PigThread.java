package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PigThread extends Thread{

    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }


    protected void buildHouse(int buildTime) {
        System.out.println(pigName + " starts building a house with " + material + "...");
        try {
            Thread.sleep(buildTime);
        } catch (InterruptedException e) {
            System.err.println(pigName + " was interrupted during building.");
        }
        System.out.println(pigName + " finishes building the house with " + material + "!");
    }
}
