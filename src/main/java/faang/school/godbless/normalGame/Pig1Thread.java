package faang.school.godbless.normalGame;

public class Pig1Thread extends PigThread{
    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " started building a house from " + getMaterial());
            Thread.sleep(3000);
            System.out.println(getPigName() + " built a house out of " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
