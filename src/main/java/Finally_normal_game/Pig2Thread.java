package Finally_normal_game;

public class Pig2Thread extends PigThread{

    public Pig2Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() +
                " starts to build a house out of material - " + getMaterial());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " finished.");
    }
}
