package faang.school.godbless.threads.norm_game;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Naf-Naf", "Bricks");
    }

    @Override
    public void run() {
        System.out.printf("%s начал строить дом из %s\n", getPigName(), getMaterial());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s достроил дом из %s!!!\n", getPigName(), getMaterial());
    }
}
