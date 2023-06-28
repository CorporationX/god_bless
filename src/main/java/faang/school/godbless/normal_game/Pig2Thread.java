package faang.school.godbless.normal_game;

public class Pig2Thread extends PigThread{
    public Pig2Thread(String pigName) {
        super(pigName, Material.STRAW);
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
