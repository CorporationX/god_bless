package faang.school.godbless.normal_game;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(super.getPigName() + " has started to build the house from " + super.getMaterial());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(super.getPigName() + " has finished the house from " + super.getMaterialName(getMaterial()));
    }
}
