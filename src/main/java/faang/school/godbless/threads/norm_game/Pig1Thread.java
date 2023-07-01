package faang.school.godbless.threads.norm_game;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Nif-Nif", "Straw");
    }

    @Override
    public void run() {
        System.out.printf("%s начал строить дом из %s\n", getPigName(), getMaterial());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s достроил дом из %s!!!\n", getPigName(), getMaterial());
    }
}
