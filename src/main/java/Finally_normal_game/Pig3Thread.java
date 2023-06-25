package Finally_normal_game;

public class Pig3Thread extends PigThread{

    public Pig3Thread(String pigName, int material) {
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
