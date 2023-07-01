package faang.school.godbless.threads.norm_game;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Nuf-Nuf", "Sticks");
    }

    @Override
    public void run() {
        System.out.printf("%s начал строить дом из %s\n", getPigName(), getMaterial());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s достроил дом из %s!!!\n", getPigName(), getMaterial());
    }
}
