package faang.school.godbless.finallyGoodGame;

public class Pig2Thread extends PigThread{
    public Pig2Thread() {
        super("Naf-Naf", "sticks");
    }

    @Override
    public void run() {
        System.out.println(
                this.getPigName() + " started building a house with " + this.getMaterial()
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                this.getPigName() + " has builded a house with " + this.getMaterial()
        );
    }
}
