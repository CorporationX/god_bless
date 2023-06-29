package faang.school.godbless.normalGame;

public class Pig2Thread extends PigThread{
    public Pig2Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " started building a house from " + getMaterial());
            Thread.sleep(6000);
            System.out.println(getPigName() + " built a house out of " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
