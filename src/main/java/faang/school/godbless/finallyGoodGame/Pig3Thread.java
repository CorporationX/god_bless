package faang.school.godbless.finallyGoodGame;

public class Pig3Thread extends PigThread{
    public Pig3Thread() {
        super("Nuf-Nuf", "bricks");
    }

    @Override
    public void run() {
        System.out.println(
                this.getPigName() + " started building a house with " + this.getMaterial()
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                this.getPigName() + " has builded a house with " + this.getMaterial()
        );
    }
}
