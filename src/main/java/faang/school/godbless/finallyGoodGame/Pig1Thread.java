package faang.school.godbless.finallyGoodGame;

public class Pig1Thread extends PigThread{
    public Pig1Thread() {
        super("Nif-Nif", "straw");
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
