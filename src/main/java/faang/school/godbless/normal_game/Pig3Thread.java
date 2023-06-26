package faang.school.godbless.normal_game;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(super.getPigName() + " has started to build the house from " + super.getMaterial());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(super.getPigName() + " has finished the house from " + super.getMaterialName(getMaterial()));
    }
}
