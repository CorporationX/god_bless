package finally_good_game;

import lombok.Getter;

@Getter
public class Pig2Thread extends PigThread{
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " build house from " + getMaterial());
            Thread.sleep(2000);
            System.out.println(getPigName() + " has finished building the house.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
