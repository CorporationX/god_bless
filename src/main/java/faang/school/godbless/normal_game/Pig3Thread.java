package faang.school.godbless.normal_game;

public class Pig3Thread extends PigThread{
    public Pig3Thread(String pigName) {
        super(pigName, Material.WOOD);
    }
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
