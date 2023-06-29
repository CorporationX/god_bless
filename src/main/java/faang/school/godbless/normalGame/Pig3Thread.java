package faang.school.godbless.normalGame;

public class Pig3Thread extends PigThread{
    public Pig3Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " started building a house from " + getMaterial());
            Thread.sleep(1000);
            System.out.println(getPigName() + " built a house out of " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
